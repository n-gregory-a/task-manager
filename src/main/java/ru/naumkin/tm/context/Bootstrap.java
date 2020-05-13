package ru.naumkin.tm.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.*;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
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

    @Getter
    @NotNull
    private final ITaskService taskService = new TaskService(taskRepository);

    @Getter
    @NotNull
    private final IProjectService projectService = new ProjectService(projectRepository);

    @Getter
    @NotNull
    private final IUserService userService = new UserService(userRepository);

    @Getter
    @NotNull
    private final ITerminalService terminalService = new TerminalService(reader, commands);

    @Getter
    @NotNull
    private final IDomainService domainService = new DomainService();

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

    public void init(@NotNull final Set<Class<? extends AbstractCommand>> classes) throws Exception {
        terminalService.showMessage("*** Welcome to task manager ***");
        createDefaultUser();
        @NotNull final Class abstractCommand = AbstractCommand.class;
        for (@NotNull final Class clazz: classes) {
            if (abstractCommand.isAssignableFrom(clazz)) {
                @NotNull final AbstractCommand command = (AbstractCommand) clazz.newInstance();
                registerCommand(command);
            }
        }
        @Nullable String command;
        while (true) {
            command = terminalService.readLine();
            try {
                execute(command);
            } catch (Exception e) {
//                terminalService.showMessage("Something went wrong. Please try again.");
                e.printStackTrace();
            }
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
