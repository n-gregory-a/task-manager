package ru.naumkin.tm.service;

import ru.naumkin.tm.enumerated.TerminalCommand;
import ru.naumkin.tm.manager.ProjectManager;
import ru.naumkin.tm.manager.TaskManager;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandHandler {

    private BufferedReader reader;

    private ProjectManager projectManager = new ProjectManager();
    private TaskManager taskManager = new TaskManager();

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
                System.out.println("[Unknown command]");;
                break;
        }
    }

    private void viewTasks(BufferedReader reader) throws IOException {
        projectManager.viewTasks(reader);
    }

    private void attachTask(BufferedReader reader) throws IOException {
        projectManager.attachTask(reader);
    }

    private void updateTask(BufferedReader reader) throws IOException {
        taskManager.updateTask(reader);
    }

    private void removeTask(BufferedReader reader) throws IOException {
        taskManager.deleteTask(reader);
    }

    private void createTask(BufferedReader reader) throws IOException {
        taskManager.createTask(reader);
    }

    private void readTaskList() {
        taskManager.readTaskList();
    }

    private void clearTasks() {
        taskManager.deleteAllTasks();
    }

    private void readProject(BufferedReader reader) throws IOException {
        projectManager.readProject(reader);
    }

    private void updateProject(BufferedReader reader) throws IOException {
        projectManager.updateProject(reader);
    }

    private void removeProject(BufferedReader reader) throws IOException {
        projectManager.deleteProject(reader);
    }

    private void readProjectList() {
        projectManager.readProjectList();
    }

    private void createProject(BufferedReader reader) throws IOException {
        projectManager.createProject(reader);
    }

    private void clearProjects() {
        projectManager.deleteAllProjects();
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
