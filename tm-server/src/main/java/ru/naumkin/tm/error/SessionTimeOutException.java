package ru.naumkin.tm.error;

public class SessionTimeOutException extends RuntimeException {

    public SessionTimeOutException() {
        super("Session time is out.");
    }
}
