package ru.naumkin.tm.error;

public final class EntityIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Entity not found.";
    }

}
