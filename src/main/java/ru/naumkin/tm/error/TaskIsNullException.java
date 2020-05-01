package ru.naumkin.tm.error;

public class TaskIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Task not found.";
    }
}
