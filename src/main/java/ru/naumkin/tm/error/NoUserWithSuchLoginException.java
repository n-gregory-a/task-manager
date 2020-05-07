package ru.naumkin.tm.error;

import org.jetbrains.annotations.NotNull;

public final class NoUserWithSuchLoginException extends RuntimeException {

    private final String login;

    public NoUserWithSuchLoginException(final @NotNull String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "No user with login " + login + '.';
    }

}
