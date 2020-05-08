package ru.naumkin.tm.enumerated;

import org.jetbrains.annotations.NotNull;

public enum RoleType {

    ADMINISTRATOR("administrator"),
    USER("User");

    private final String role;

    RoleType(final @NotNull String role) {
        this.role = role;
    }

    public @NotNull String displayName() {
        return role;
    }
}
