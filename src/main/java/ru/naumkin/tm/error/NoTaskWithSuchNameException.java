package ru.naumkin.tm.error;

import org.jetbrains.annotations.NotNull;

public final class NoTaskWithSuchNameException extends RuntimeException {

    private final String name;

    public NoTaskWithSuchNameException(final @NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "No task with name " + name + '.';
    }
}
