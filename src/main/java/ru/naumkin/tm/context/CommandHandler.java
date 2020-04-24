package ru.naumkin.tm.context;

import ru.naumkin.tm.enumerated.TerminalCommand;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandHandler {

    private BufferedReader reader;

    private ProjectService projectService = new ProjectService();

    private TaskService taskService = new TaskService();

    public CommandHandler(BufferedReader reader) {
        this.reader = reader;
    }

    public void handleCommand(TerminalCommand command) throws IOException {
        switch (command) {
            case HELP:
                help();
                break;
            case PROJECT_CLEAR:
                clearProjects();
                break;
            case PROJECT_CREATE:
                createProject(reader);
                break;
            case PROJECT_LIST:
                readProjectList();
                break;
            case PROJECT_NAME:
                readProject(reader);
                break;
            case PROJECT_UPDATE:
                updateProject(reader);
                break;
            case PROJECT_REMOVE:
                removeProject(reader);
                break;
            case TASK_CLEAR:
                clearTasks();
                break;
            case TASK_CREATE:
                createTask(reader);
                break;
            case TASK_LIST:
                readTaskList();
                break;
            case TASK_NAME:
                readTask(reader);
                break;
            case TASK_REMOVE:
                removeTask(reader);
                break;
            case TASK_UPDATE:
                updateTask(reader);
                break;
            case TASK_ATTACH:
                attachTask(reader);
                break;
            case TASKS_VIEW:
                viewTasks(reader);
                break;
            case UNEXPECTED_VALUE:
                System.out.println("[Unknown command]");
                break;
        }
    }

    private void viewTasks(BufferedReader reader) throws IOException {
        projectService.viewTasks(reader);
    }

    private void attachTask(BufferedReader reader) throws IOException {
        projectService.attachTask(reader);
    }

    private void updateTask(BufferedReader reader) throws IOException {
        taskService.updateTask(reader);
    }

    private void removeTask(BufferedReader reader) throws IOException {
        taskService.deleteTask(reader);
    }

    private void createTask(BufferedReader reader) throws IOException {
        taskService.createTask(reader);
    }

    private void readTask(BufferedReader reader) throws IOException {
        taskService.readTask(reader);
    }

    private void readTaskList() {
        taskService.readTaskList();
    }

    private void clearTasks() {
        taskService.deleteAllTasks();
    }

    private void readProject(BufferedReader reader) throws IOException {
        projectService.readProject(reader);
    }

    private void updateProject(BufferedReader reader) throws IOException {
        projectService.updateProject(reader);
    }

    private void removeProject(BufferedReader reader) throws IOException {
        projectService.deleteProject(reader);
    }

    private void readProjectList() {
        projectService.readProjectList();
    }

    private void createProject(BufferedReader reader) throws IOException {
        projectService.createProject(reader);
    }

    private void clearProjects() {
        projectService.deleteAllProjects();
    }

    private void help() {
        System.out.println(
                "help: Show all commands." +
                        "\nproject-clear: Remove all projects." +
                        "\nproject-create: Create new project." +
                        "\nproject-update: Update project" +
                        "\nproject-list: Show all projects." +
                        "\nproject-name: Show project by name." +
                        "\nproject-remove: Remove selected project" +
                        "\ntask-clear: Remove all tasks." +
                        "\ntask-create: Create new task." +
                        "\ntask-update: Update task" +
                        "\ntask-list: Show all tasks." +
                        "\ntask-name: Show task by name" +
                        "\ntask-attach: attach task to the project" +
                        "\ntasks-view: show all tasks attached to the project" +
                        "\nexit: Exit program."
        );
    }

    public TerminalCommand readCommand(BufferedReader reader) throws IOException {
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

}
