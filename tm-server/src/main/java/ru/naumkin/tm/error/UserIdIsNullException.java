package ru.naumkin.tm.error;

public final class UserIdIsNullException extends RuntimeException {

    public UserIdIsNullException() {
        super("Current user id is null.");
    }

}
