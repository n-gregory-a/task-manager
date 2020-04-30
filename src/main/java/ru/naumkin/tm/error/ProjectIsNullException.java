package ru.naumkin.tm.error;

public class ProjectIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Project is null.";
    }

}
