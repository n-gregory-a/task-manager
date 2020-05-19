package ru.naumkin.tm.error;

public final class NameIsNullException extends RuntimeException {

    public NameIsNullException() {
        super("The name is null.");
    }

}
