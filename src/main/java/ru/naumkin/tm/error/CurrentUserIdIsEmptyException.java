package ru.naumkin.tm.error;

public class CurrentUserIdIsEmptyException extends RuntimeException {

    @Override
    public String toString() {
        return "Current user id is empty.";
    }
}
