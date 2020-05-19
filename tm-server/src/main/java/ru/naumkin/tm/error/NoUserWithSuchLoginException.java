package ru.naumkin.tm.error;

public final class NoUserWithSuchLoginException extends RuntimeException {

    public NoUserWithSuchLoginException(final String login) {
        super("No user with login " + login + '.');
    }

}
