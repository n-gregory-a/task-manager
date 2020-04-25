package ru.naumkin.tm.view;

import java.io.BufferedReader;
import java.io.IOException;

public class View {

    private BufferedReader reader;

    public View(BufferedReader reader) {
        this.reader = reader;
    }

    public void showHelp() {
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

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

}
