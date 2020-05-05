package ru.naumkin.tm.error;

public final class UserIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "User is null.";
    }
}
