package ru.naumkin.tm.error;

import org.jetbrains.annotations.NotNull;

public final class NoProjectWithSuchNameException extends RuntimeException {

    private final String name;

    public NoProjectWithSuchNameException(final @NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "No project with name " + name +".";
    }

}
