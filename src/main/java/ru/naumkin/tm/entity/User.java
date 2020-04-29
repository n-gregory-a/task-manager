package ru.naumkin.tm.entity;

import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

import java.util.UUID;

public class User {

    private final String ID = UUID.randomUUID().toString();

    private String login = "user";

    private String password = HashGenerator.getHash("password");

    private RoleType role = RoleType.USER;

    public User() {
    }

    public String getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", role=" + role.displayName() +
                '}';
    }
}
