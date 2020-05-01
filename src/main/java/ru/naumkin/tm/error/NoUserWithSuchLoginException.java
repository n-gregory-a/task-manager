package ru.naumkin.tm.error;

public class NoUserWithSuchLoginException extends RuntimeException {

    private final String login;

    public NoUserWithSuchLoginException(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "No user with login " + login + '.';
    }

}
