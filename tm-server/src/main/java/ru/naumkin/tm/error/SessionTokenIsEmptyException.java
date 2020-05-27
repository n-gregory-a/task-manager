package ru.naumkin.tm.error;

public class SessionTokenIsEmptyException extends RuntimeException {

    public SessionTokenIsEmptyException() {
        super("Session token is empty.");
    }

}
