package ru.naumkin.tm.context;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.enumerated.TerminalCommand;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.util.DateFormatter;
import ru.naumkin.tm.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bootstrap {

    private TaskRepository taskRepository = new TaskRepository();

    private ProjectRepository projectRepository = new ProjectRepository(taskRepository);

    private TaskService taskService = new TaskService(taskRepository);

    private ProjectService projectService = new ProjectService(projectRepository);

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private View view = new View(reader);

    public void init() throws IOException {
        view.showMessage("*** Welcome to task manager ***");
        while (true) {
            TerminalCommand command = readCommand(reader);
            boolean commandIsExit = command.getCommand().equals(TerminalCommand.EXIT.getCommand());
            if (commandIsExit) {
                reader.close();
                System.exit(1);
            } else {
                handleCommand(command);
            }
        }
    }

    private void handleCommand(TerminalCommand command) throws IOException {
        switch (command) {
            case HELP:
                showHelp();
                break;
            case PROJECT_CLEAR:
                clearProjects();
                break;
            case PROJECT_CREATE:
                createProject();
                break;
            case PROJECT_LIST:
                readProjectList();
                break;
            case PROJECT_READ:
                readProject();
                break;
            case PROJECT_UPDATE:
                updateProject();
                break;
            case PROJECT_REMOVE:
                removeProject();
                break;
            case TASK_CLEAR:
                clearTasks();
                break;
            case TASK_CREATE:
                createTask();
                break;
            case TASK_LIST:
                readTaskList();
                break;
            case TASK_READ:
                readTask();
                break;
            case TASK_REMOVE:
                removeTask();
                break;
            case TASK_UPDATE:
                updateTask();
                break;
            case TASK_ATTACH:
                attachTask();
                break;
            case TASKS_VIEW:
                viewTasks();
                break;
            case UNEXPECTED_VALUE:
                view.showMessage("Unexpected command");
                break;
        }
    }

    private void createProject() throws IOException {
        view.showMessage("[PROJECT CREATE]");
        view.showMessage("Enter name: ");
        Project project = new Project(view.readLine());

        projectService.persist(project);
        view.showMessage("[OK]");
    }

    private void readProjectList() {
        view.showMessage("[PROJECT LIST]");
        for (Project project: projectService.findAll()) {
            view.showMessage(project.toString());
        }
    }

    private void readProject() throws IOException {
        view.showMessage("[PROJECT READ]");
        Project project = getProjectByName();
        view.showMessage(project.toString());
    }

    private void updateProject() throws IOException {
        view.showMessage("[PROJECT UPDATE]");
        view.showMessage("Enter project name: ");
        Project project = new Project(view.readLine());
        String name = project.getName();

        view.showMessage("Enter new name: ");
        project.setName(view.readLine());

        view.showMessage("Enter new description: ");
        project.setDescription(view.readLine());

        view.showMessage("Enter new start date(dd.mm.yyyy): ");
        project.setDateStart(DateFormatter.convertStringToDate(view.readLine()));

        view.showMessage("Enter new finish date(dd.mm.yyyy): ");
        project.setDateFinish(DateFormatter.convertStringToDate(view.readLine()));

        try {
            projectService.merge(project, name);
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
            return;
        }
        view.showMessage("[OK]");
    }

    private void removeProject() throws IOException {
        view.showMessage("[PROJECT REMOVE]");
        if (projectService.findAll().isEmpty()) {
            view.showMessage("[Project list is empty]");
        } else {
            Project project = getProjectByName();
            projectService.remove(project);
            view.showMessage("[OK]");
        }
    }

    private void clearProjects() {
        view.showMessage("[PROJECT LIST CLEAR]");
        projectService.removeAll();
        view.showMessage("[OK]");
    }

    private void createTask() throws IOException {
        view.showMessage("[TASK CREATE]");
        Task task = new Task(view.readLine());
        taskService.persist(task);
        view.showMessage("[OK]");
    }

    private void readTaskList() {
        view.showMessage("[TASK LIST]");
        for (Task task: taskService.findAll()) {
            view.showMessage(task.toString());
        }
    }

    private void readTask() throws IOException {
        view.showMessage("[TASK READ]");
        Task task = getTaskByName();
        view.showMessage(task.toString());
    }

    private void removeTask() throws IOException {
        view.showMessage("[TASK REMOVE]");
        Task task = getTaskByName();
        taskService.remove(task);
        view.showMessage("[OK]");
    }

    private void updateTask() throws IOException {
        view.showMessage("[TASK UPDATE]");
        Task task = getTaskByName();
        String name = task.getName();
        view.showMessage("Enter new name: ");
        task.setName(view.readLine());
        view.showMessage("Enter new description: ");
        task.setDescription(view.readLine());
        view.showMessage("Enter new start date(dd.mm.yyyy): ");
        task.setDateStart(DateFormatter.convertStringToDate(view.readLine()));
        view.showMessage("Enter new finish date(dd.mm.yyyy): ");
        task.setDateFinish(DateFormatter.convertStringToDate(view.readLine()));
        taskService.merge(task, name);
        view.showMessage("[OK]");
    }

    private void clearTasks() {
        view.showMessage("[TASK LIST CLEAR]");
        taskService.removeAll();
        view.showMessage("[OK]");
    }

    private void attachTask() throws IOException {
        view.showMessage("[TASK ATTACH]");
        Project project = getProjectByName();
        Task task = getTaskByName();
        task.setProjectId(project.getID());
        view.showMessage("[OK]");
    }

    private void viewTasks() throws IOException {
        view.showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        Project project = getProjectByName();
        for (Task task: taskService.findAll()) {
            boolean taskAttachedToProject = task.getProjectId().equals(project.getID());
            if (taskAttachedToProject) {
                view.showMessage(task.toString());
            }
        }
    }

    private TerminalCommand readCommand(BufferedReader reader) throws IOException {
        String commandString = reader.readLine();
        TerminalCommand command = null;

        for (TerminalCommand c: TerminalCommand.values()) {
            if (c.getCommand().equals(commandString)) {
                command = c;
            }
        }

        if (command != null) {
            return command;
        } else {
            return TerminalCommand.UNEXPECTED_VALUE;
        }
    }

    private void showHelp() {
        view.showHelp();
    }

    private Project getProjectByName() throws IOException {
        view.showMessage("Enter project name: ");
        Project project;

        try {
            project = projectService.findOne(view.readLine());
        } catch (IllegalArgumentException | NullPointerException e) {
            view.showMessage(e.getMessage());
            project = getProjectByName();
        }

        return project;
    }

    private Task getTaskByName() throws IOException {
        view.showMessage("Enter task name: ");
        Task task;

        try {
            task = taskService.findOne(view.readLine());
        } catch (IllegalArgumentException | NullPointerException e) {
            view.showMessage(e.getMessage());
            task = getTaskByName();
        }

        return task;
    }

}
