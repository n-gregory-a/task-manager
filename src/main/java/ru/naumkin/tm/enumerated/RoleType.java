package ru.naumkin.tm.enumerated;

public enum RoleType {

    ADMINISTRATOR("administrator"),
    USER("User");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    public String displayName() {
        return role;
    }
}
