package ru.naumkin.tm.error;

public class SessionValidationException extends RuntimeException {

    public SessionValidationException() {
        super(" Session is not valid.");
    }
}
