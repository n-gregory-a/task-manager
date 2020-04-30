package ru.naumkin.tm.error;

public class CurrentUserIdIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Current user id is null.";
    }
}
