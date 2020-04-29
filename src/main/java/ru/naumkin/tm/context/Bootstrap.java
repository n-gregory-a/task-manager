package ru.naumkin.tm.context;

import ru.naumkin.tm.command.*;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.service.UserService;
import ru.naumkin.tm.util.HashGenerator;
import ru.naumkin.tm.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bootstrap {

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final ProjectService projectService = new ProjectService(projectRepository);

    private final UserRepository userRepository = new UserRepository();

    private final UserService userService = new UserService(userRepository);

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final View view = new View(reader);

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private User currentUser = new User();

    public Bootstrap() {
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public UserService getUserService() {
        return userService;
    }

    public View getView() {
        return view;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
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
        command.setBootstrap(this);
        commands.put(cliCommand, command);
    }

    public void init() throws Exception {
        view.showMessage("*** Welcome to task manager ***");
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
        String command;
        while (true) {
            command = view.readLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) {
            return;
        }
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) {
            return;
        }
        abstractCommand.execute();
    }

    public List<AbstractCommand> getCommands() {
        return new ArrayList<>(commands.values());
    }

    public void createDefaultUser() {
        User user = new User();
        User administrator = new User();
        administrator.setLogin("admin");
        administrator.setPassword(HashGenerator.getHash("MeG@$tr0nG@dmiN$p@$$w0rD"));
        administrator.setRole(RoleType.ADMINISTRATOR);
        userService.persist(user);
        userService.persist(administrator);
        setCurrentUser(user);
    }

}
