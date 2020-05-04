package ru.naumkin.tm.error;

public class EntityIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Entity not found.";
    }

}
