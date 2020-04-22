package ru.naumkin.tm.util;

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

    public void handleCommand(String command) throws IOException {
//        String command = reader.readLine().toLowerCase().trim();
        switch (command) {
            case ("help"):
                help();
                break;

            case ("project-clear"):
                clearProjects();
                break;

            case ("project-create"):
                createProject(reader);
                break;

            case ("project-list"):
                readProjectList();
                break;

            case ("project-name"):
                readProject(reader);
                break;

            case ("project-update"):
                updateProject(reader);
                break;

            case ("project-remove"):
                removeProject(reader);
                break;

            case ("task-clear"):
                clearTasks();
                break;

            case ("task-create"):
                createTask(reader);
                break;

            case ("task-list"):
                readTaskList();
                break;

            case ("task-remove"):
                removeTask(reader);
                break;

            case ("task-update"):
                updateTask(reader);
                break;

            default:
                System.out.println("Unexpected value: " + command);
        }
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
                        "\nexit: Exit program."
        );
    }
}
