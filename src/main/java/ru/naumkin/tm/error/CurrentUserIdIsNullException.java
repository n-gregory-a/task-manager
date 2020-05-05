package ru.naumkin.tm.error;

public final class CurrentUserIdIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Current user id is null.";
    }
}
