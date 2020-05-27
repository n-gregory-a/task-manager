package ru.naumkin.tm.error;

public class SessionTokenIsNullException extends RuntimeException {

    public SessionTokenIsNullException() {
        super("Session token is null.");
    }

}
