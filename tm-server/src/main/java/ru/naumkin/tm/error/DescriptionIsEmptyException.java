package ru.naumkin.tm.error;

public final class DescriptionIsEmptyException extends RuntimeException {

    public DescriptionIsEmptyException() {
        super("Description is empty.");
    }

}
