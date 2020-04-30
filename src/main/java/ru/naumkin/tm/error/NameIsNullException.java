package ru.naumkin.tm.error;

public class NameIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "The name is null.";
    }

}
