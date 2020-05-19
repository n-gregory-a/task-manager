package ru.naumkin.tm.error;

public final class IdIsEmptyException extends RuntimeException {

    public IdIsEmptyException() {
        super("Id is empty.");
    }

}
