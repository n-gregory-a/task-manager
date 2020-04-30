package ru.naumkin.tm.error;

public class NameIsEmptyException extends RuntimeException {

    @Override
    public String toString() {
        return "The name is empty.";
    }

}
