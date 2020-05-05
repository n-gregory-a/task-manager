package ru.naumkin.tm.entity;

import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

public final class User extends AbstractEntity {

    private String password = HashGenerator.getHash("password");

    private RoleType role = RoleType.USER;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(final RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "login: " + getName() +
                ", role: " + role.displayName() +
                '}';
    }
}
