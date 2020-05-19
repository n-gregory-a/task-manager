package ru.naumkin.tm.error;

public final class NoProjectWithSuchNameException extends RuntimeException {

    public NoProjectWithSuchNameException(final String name) {
        super("No project with name " + name +".");
    }

}
