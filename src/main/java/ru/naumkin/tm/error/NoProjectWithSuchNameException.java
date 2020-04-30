package ru.naumkin.tm.error;

public class NoProjectWithSuchNameException extends RuntimeException {

    private final String name;

    public NoProjectWithSuchNameException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "No project with name " + name +".";
    }

}
