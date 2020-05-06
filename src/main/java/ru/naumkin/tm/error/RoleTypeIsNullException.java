package ru.naumkin.tm.error;

public class RoleTypeIsNullException extends RuntimeException {

    @Override
    public String toString() {
        return "Role not found.";
    }

}
