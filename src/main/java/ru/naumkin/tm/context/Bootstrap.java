package ru.naumkin.tm.context;

import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.command.project.*;
import ru.naumkin.tm.command.system.AboutCommand;
import ru.naumkin.tm.command.system.ExitCommand;
import ru.naumkin.tm.command.system.HelpCommand;
import ru.naumkin.tm.command.task.*;
import ru.naumkin.tm.command.user.*;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.service.UserService;
import ru.naumkin.tm.view.TerminalService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Bootstrap implements ServiceLocator {

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final ProjectService projectService = new ProjectService(projectRepository);

    private final UserRepository userRepository = new UserRepository();

    private final UserService userService = new UserService(userRepository);

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final TerminalService terminalService = new TerminalService(reader);

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private User currentUser;

    public Bootstrap() {
    }

    @Override
    public ITaskService getTaskService() {
        return taskService;
    }

    @Override
    public IProjectService getProjectService() {
        return projectService;
    }

    @Override
    public IService<User> getUserService() {
        return userService;
    }

    @Override
    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public List<AbstractCommand> getCommand() {
        return new ArrayList<>(commands.values());
    }

    @Override
    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public void registerCommand(final AbstractCommand command) {
        final String cliCommand = command.getName();
        final String cliDescription = command.getDescription();
        if (cliCommand == null || cliCommand.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (cliDescription == null || cliDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        command.setServiceLocator(this);
        commands.put(cliCommand, command);
    }

    public void init() throws Exception {
        terminalService.showMessage("*** Welcome to task manager ***");
        createDefaultUser();
        registerCommand(new HelpCommand());
        registerCommand(new ProjectClearCommand());
        registerCommand(new ProjectCreateCommand());
        registerCommand(new ProjectListCommand());
        registerCommand(new ProjectReadCommand());
        registerCommand(new ProjectRemoveCommand());
        registerCommand(new ProjectUpdateCommand());
        registerCommand(new TaskAttachCommand());
        registerCommand(new TaskClearCommand());
        registerCommand(new TaskCreateCommand());
        registerCommand(new TaskListCommand());
        registerCommand(new TaskReadCommand());
        registerCommand(new TaskRemoveCommand());
        registerCommand(new TaskUpdateCommand());
        registerCommand(new TaskViewCommand());
        registerCommand(new ExitCommand());
        registerCommand(new UserChangePasswordCommand());
        registerCommand(new UserLogInCommand());
        registerCommand(new UserLogOutCommand());
        registerCommand(new UserReadCommand());
        registerCommand(new UserRegisterCommand());
        registerCommand(new UserUpdateCommand());
        registerCommand(new AboutCommand());
        String command;
        while (true) {
            command = terminalService.readLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) {
            return;
        }
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) {
            getTerminalService().showMessage("Unknown command");
            return;
        }
        final boolean secureCheck = !abstractCommand.isSecure() ||
                (abstractCommand.isSecure() && getCurrentUser() != null);
        final boolean roleCheck = (abstractCommand.getRoles() == null) ||
                (abstractCommand.getRoles() != null &&
                        userService.isRoleAdmin(currentUser));
        if (secureCheck && roleCheck) {
            abstractCommand.execute();
            return;
        }
        getTerminalService().showMessage("This command is not allowed.");
    }

    public void createDefaultUser() {
        User user = userService.createUser(RoleType.USER);
        User administrator = userService.createUser(RoleType.ADMINISTRATOR);
        setCurrentUser(user);
    }

}
