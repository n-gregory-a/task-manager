package ru.naumkin.tm.error;

public final class EntityIsNullException extends RuntimeException {

    public EntityIsNullException() {
        super("Entity not found.");
    }

}
