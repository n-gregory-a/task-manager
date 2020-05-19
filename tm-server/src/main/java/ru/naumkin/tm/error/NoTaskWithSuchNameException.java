package ru.naumkin.tm.error;

public final class NoTaskWithSuchNameException extends RuntimeException {

    public NoTaskWithSuchNameException(final String name) {
        super("No task with name " + name + '.');
    }

}
