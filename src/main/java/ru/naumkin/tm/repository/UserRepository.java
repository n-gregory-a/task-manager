package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> users = new LinkedHashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User findOne(String login) {
        return users.get(login);
    }

    public User persist(User user) {
        return users.put(user.getLogin(), user);
    }

    public User merge(User user, String login) throws NoSuchAlgorithmException {
        User updatingUser = users.get(login);
        updatingUser.setLogin(login);
        updatingUser.setPassword(user.getPassword());
        updatingUser.setRole(user.getRole());
        users.remove(login);
        return users.put(updatingUser.getLogin(), updatingUser);
    }

    public User remove(User user) {
        return users.remove(user.getLogin());
    }

    public void removeAll() {
        users.clear();
    }

}
