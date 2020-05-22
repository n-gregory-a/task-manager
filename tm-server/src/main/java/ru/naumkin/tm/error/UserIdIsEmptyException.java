package ru.naumkin.tm.error;

public final class UserIdIsEmptyException extends RuntimeException {

    public UserIdIsEmptyException() {
        super("Current user id is empty.");
    }

}
