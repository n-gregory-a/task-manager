package ru.naumkin.tm.error;

public final class NameIsEmptyException extends RuntimeException {

    @Override
    public String toString() {
        return "The name is empty.";
    }

}
