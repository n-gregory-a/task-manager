package ru.naumkin.tm.error;

public class NoUserWithSuchIdException extends RuntimeException {

    public NoUserWithSuchIdException(String s) {
        super("No user with id " + s);
    }

}
