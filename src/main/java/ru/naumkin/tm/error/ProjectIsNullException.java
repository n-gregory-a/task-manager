package ru.naumkin.tm.error;

public final class ProjectIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Project not found.";
    }

}
