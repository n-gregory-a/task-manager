package ru.naumkin.tm.error;

public final class NoUserWithSuchLoginException extends RuntimeException {

    private final String login;

    public NoUserWithSuchLoginException(final String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "No user with login " + login + '.';
    }

}
