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

    @NotNull
    private final ITaskRepository taskRepository = new TaskRepository();

    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepository(taskRepository);

    @NotNull
    private final IRepository<User> userRepository = new UserRepository();

    @NotNull
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @NotNull
    private final  Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private final ITaskService taskService = new TaskService(taskRepository);

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final IUserService userService = new UserService(userRepository);

    private final ITerminalService terminalService = new TerminalService(reader, commands);

    public Bootstrap() {
    }

    @NotNull
    @Override
    public ITaskService getTaskService() {
        return taskService;
    }

    @NotNull
    @Override
    public IProjectService getProjectService() {
        return projectService;
    }

    @NotNull
    @Override
    public IUserService getUserService() {
        return userService;
    }

    @NotNull
    @Override
    public ITerminalService getTerminalService() {
        return terminalService;
    }

    public void registerCommand(@NotNull final AbstractCommand command) {
        @Nullable final String cliCommand = command.getName();
        @Nullable final String cliDescription = command.getDescription();
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
        for (@NotNull final Class clazz: classes) {
            if (abstractCommand.isAssignableFrom(clazz)) {
                @NotNull final AbstractCommand command = (AbstractCommand) clazz.newInstance();
                registerCommand(command);
            }
        }
        @Nullable String command;
        while (true) {
            command = terminalService.readLine();
            execute(command);
        }
    }

    private void execute(@Nullable final String command) throws Exception {
        if (command == null || command.isEmpty()) {
            return;
        }
        @Nullable final AbstractCommand abstractCommand = commands.get(command);
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
