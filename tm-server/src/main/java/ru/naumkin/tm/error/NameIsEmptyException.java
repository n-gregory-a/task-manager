package ru.naumkin.tm.error;

public final class NameIsEmptyException extends RuntimeException {

    public NameIsEmptyException() {
        super("The name is empty.");
    }

}
