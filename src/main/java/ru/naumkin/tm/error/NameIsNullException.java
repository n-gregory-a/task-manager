package ru.naumkin.tm.error;

public final class NameIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "The name is null.";
    }

}
