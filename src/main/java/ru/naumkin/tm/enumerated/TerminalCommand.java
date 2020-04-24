package ru.naumkin.tm.enumerated;

public enum  TerminalCommand {

    EXIT("exit"),
    HELP("help"),
    PROJECT_CLEAR("project-clear"),
    PROJECT_CREATE("project-create"),
    PROJECT_LIST("project-list"),
    PROJECT_NAME("project-name"),
    PROJECT_REMOVE("project-remove"),
    PROJECT_UPDATE("project-update"),
    TASK_CLEAR("task-clear"),
    TASK_CREATE("task-create"),
    TASK_LIST("task-list"),
    TASK_REMOVE("task-remove"),
    TASK_UPDATE("task-update"),
    TASK_ATTACH("task-attach"),
    TASKS_VIEW("tasks-view"),
    UNEXPECTED_VALUE("");

    private final String command;

    TerminalCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public String getCommand() {
        return command;
    }

}
