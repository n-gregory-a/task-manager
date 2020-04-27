package ru.naumkin.tm.context;

import ru.naumkin.tm.comand.*;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bootstrap {

    private TaskRepository taskRepository = new TaskRepository();

    private ProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private TaskService taskService = new TaskService(taskRepository);

    private ProjectService projectService = new ProjectService(projectRepository);

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private View view = new View(reader);

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    public TaskService getTaskService() {
        return taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public View getView() {
        return view;
    }

    public void registry(final AbstractCommand command) {
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
        registry(new HelpCommand());
        registry(new ProjectClearCommand());
        registry(new ProjectCreateCommand());
        registry(new ProjectListCommand());
        registry(new ProjectReadCommand());
        registry(new ProjectRemoveCommand());
        registry(new ProjectUpdateCommand());
        registry(new TaskAttachCommand());
        registry(new TaskClearCommand());
        registry(new TaskCreateCommand());
        registry(new TaskListCommand());
        registry(new TaskReadCommand());
        registry(new TaskRemoveCommand());
        registry(new TaskUpdateCommand());
        registry(new TaskViewCommand());
        String command = "";
        while (!"exit".equals(command)) {
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

}
