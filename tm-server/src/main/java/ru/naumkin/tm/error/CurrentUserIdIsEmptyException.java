package ru.naumkin.tm.error;

public final class CurrentUserIdIsEmptyException extends RuntimeException {

    public CurrentUserIdIsEmptyException() {
        super("Current user id is empty.");
    }

}
