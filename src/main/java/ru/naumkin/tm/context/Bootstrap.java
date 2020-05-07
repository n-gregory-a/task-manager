package ru.naumkin.tm.context;

import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.api.service.IUserService;
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
import ru.naumkin.tm.service.TerminalService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Bootstrap implements ServiceLocator {

    private final ITaskRepository taskRepository = new TaskRepository();

    private final IProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private final ITaskService taskService = new TaskService(taskRepository);

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final IRepository<User> userRepository = new UserRepository();

    private final IUserService userService = new UserService(userRepository);

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private final ITerminalService terminalService = new TerminalService(reader, commands);

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
    public IUserService getUserService() {
        return userService;
    }

    @Override
    public ITerminalService getTerminalService() {
        return terminalService;
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
