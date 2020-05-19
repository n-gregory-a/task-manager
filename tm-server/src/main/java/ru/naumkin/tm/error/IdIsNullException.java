package ru.naumkin.tm.error;

public final class IdIsNullException extends RuntimeException {

    public IdIsNullException() {
        super("Id is null.");
    }

}
