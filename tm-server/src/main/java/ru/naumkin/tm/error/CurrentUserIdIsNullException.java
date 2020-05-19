package ru.naumkin.tm.error;

public final class CurrentUserIdIsNullException extends RuntimeException {

    public CurrentUserIdIsNullException() {
        super("Current user id is null.");
    }

}
