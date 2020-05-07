package ru.naumkin.tm.error;

public final class NoProjectWithSuchNameException extends RuntimeException {

    private final String name;

    public NoProjectWithSuchNameException(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "No project with name " + name +".";
    }

}
