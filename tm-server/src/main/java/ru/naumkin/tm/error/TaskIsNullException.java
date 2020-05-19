package ru.naumkin.tm.error;

public final class TaskIsNullException extends RuntimeException {

    public TaskIsNullException() {
        super("Task not found.");
    }

}
