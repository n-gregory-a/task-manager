package ru.naumkin.tm.error;

public class PasswordIsIncorrectException extends RuntimeException {

    public PasswordIsIncorrectException() {
        super("Password is incorrect.");
    }
}
