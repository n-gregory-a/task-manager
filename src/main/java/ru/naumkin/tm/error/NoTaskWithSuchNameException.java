package ru.naumkin.tm.error;

public class NoTaskWithSuchNameException extends RuntimeException {

    private final String name;

    public NoTaskWithSuchNameException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "No task with name " + name + '.';
    }
}
