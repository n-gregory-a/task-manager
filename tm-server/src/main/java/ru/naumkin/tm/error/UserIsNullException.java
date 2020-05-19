package ru.naumkin.tm.error;

public final class UserIsNullException extends RuntimeException {

    public UserIsNullException() {
        super("User is null.");
    }

}
