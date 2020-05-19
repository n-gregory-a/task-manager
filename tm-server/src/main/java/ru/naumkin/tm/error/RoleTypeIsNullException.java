package ru.naumkin.tm.error;

public class RoleTypeIsNullException extends RuntimeException {

    public RoleTypeIsNullException() {
        super("Role not found.");
    }

}
