package ru.naumkin.tm.context;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.service.TerminalService;
import ru.naumkin.tm.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Bootstrap implements ServiceLocator {

    private final @NotNull ITaskRepository taskRepository = new TaskRepository();

    private final @NotNull IProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private final ITaskService taskService = new TaskService(taskRepository);

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final @NotNull IRepository<User> userRepository = new UserRepository();

    private final IUserService userService = new UserService(userRepository);

    private final @NotNull BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final @NotNull Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private final ITerminalService terminalService = new TerminalService(reader, commands);

    public Bootstrap() {
    }

    @Override
    public @NotNull ITaskService getTaskService() {
        return taskService;
    }

    @Override
    public @NotNull IProjectService getProjectService() {
        return projectService;
    }

    @Override
    public @NotNull IUserService getUserService() {
        return userService;
    }

    @Override
    public @NotNull ITerminalService getTerminalService() {
        return terminalService;
    }

    public void registerCommand(final @NotNull AbstractCommand command) {
        final @NotNull String cliCommand = command.getName();
        final @NotNull String cliDescription = command.getDescription();
        if (cliCommand == null || cliCommand.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (cliDescription == null || cliDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        command.setServiceLocator(this);
        commands.put(cliCommand, command);
    }

    public void init(@NotNull Class[] classes) throws Exception {
        terminalService.showMessage("*** Welcome to task manager ***");
        createDefaultUser();
        Class abstractCommand = AbstractCommand.class;
        for (final @NotNull Class clazz: classes) {
            if (abstractCommand.isAssignableFrom(clazz)) {
                final @NotNull AbstractCommand command = (AbstractCommand) clazz.newInstance();
                registerCommand(command);
            }
        }
        @Nullable String command;
        while (true) {
            command = terminalService.readLine();
            execute(command);
        }
    }

    private void execute(final @Nullable String command) throws Exception {
        if (command == null || command.isEmpty()) {
            return;
        }
        final @Nullable AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) {
            getTerminalService().showMessage("Unknown command");
            return;
        }
        final boolean secureCheck = !abstractCommand.isSecure() ||
                (abstractCommand.isSecure() && userService.getCurrentUser() != null);
        final boolean roleCheck = (abstractCommand.getRoles() == null) ||
                (abstractCommand.getRoles() != null &&
                        userService.isRoleAdmin());
        if (secureCheck && roleCheck) {
            abstractCommand.execute();
            return;
        }
        getTerminalService().showMessage("This command is not allowed.");
    }

    public void createDefaultUser() {
        User user = userService.createUser(RoleType.USER);
        User administrator = userService.createUser(RoleType.ADMINISTRATOR);
        userService.setCurrentUser(user);
    }

}
