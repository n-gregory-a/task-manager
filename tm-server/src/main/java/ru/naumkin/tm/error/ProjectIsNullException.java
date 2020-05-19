package ru.naumkin.tm.error;

public final class ProjectIsNullException extends RuntimeException {

    public ProjectIsNullException() {
        super("Project not found.");
    }

}
