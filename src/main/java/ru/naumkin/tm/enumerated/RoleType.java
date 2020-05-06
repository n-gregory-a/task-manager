package ru.naumkin.tm.enumerated;

import org.jetbrains.annotations.NotNull;

public enum RoleType {

    ADMINISTRATOR("administrator"),
    USER("User");

    private final String role;

    RoleType(@NotNull final String role) {
        this.role = role;
    }

    public String displayName() {
        return role;
    }
}
