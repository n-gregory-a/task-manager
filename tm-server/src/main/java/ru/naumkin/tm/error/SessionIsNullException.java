package ru.naumkin.tm.error;

public class SessionIsNullException extends RuntimeException {

    public SessionIsNullException() {
        super("Session does not exist.");
    }
}
