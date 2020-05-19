package ru.naumkin.tm.error;

public final class DescriptionIsNullException extends RuntimeException {

    public DescriptionIsNullException() {
        super("Description is null.");
    }

}
