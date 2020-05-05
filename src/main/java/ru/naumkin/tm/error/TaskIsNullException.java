package ru.naumkin.tm.error;

public final class TaskIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Task not found.";
    }
}
