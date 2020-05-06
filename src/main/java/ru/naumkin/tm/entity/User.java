package ru.naumkin.tm.entity;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

public final class User extends AbstractEntity {

    @NotNull
    private String password = HashGenerator.getHash("password");

    @NotNull
    private RoleType role = RoleType.USER;

    public User() {
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(final @NotNull String password) {
        this.password = password;
    }

    public @NotNull RoleType getRole() {
        return role;
    }

    public void setRole(final @NotNull RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "login: " + getName() +
                ", role: " + role.displayName() +
                '}';
    }

}
