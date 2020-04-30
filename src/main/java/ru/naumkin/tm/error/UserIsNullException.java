package ru.naumkin.tm.error;

public class UserIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "User is null.";
    }
}
