package ru.naumkin.tm.entity;

import ru.naumkin.tm.enumerated.RoleType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public class User {

    private final String ID = UUID.randomUUID().toString();

    private String login = "login";

    private String password = generateHashedPassword("password");

    private RoleType role = RoleType.USER;

    public User() throws NoSuchAlgorithmException {
    }

    public User(RoleType role) throws NoSuchAlgorithmException {
        this.role = role;
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

    public void setPassword(String password) throws NoSuchAlgorithmException {
        generateHashedPassword(password);
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    private String generateHashedPassword(String password) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b: hashedPassword) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }

}
