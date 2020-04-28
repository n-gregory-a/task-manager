package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Login is null.");
        }
        if (login.isEmpty()) {
            throw new IllegalArgumentException("Login is empty.");
        }
        User user = userRepository.findOne(login);
        if (user == null) {
            throw new NullPointerException("There is no user with login" + login);
        }
        return user;
    }

    public User persist(User user) {
        if (user == null) {
            throw new NullPointerException("There is no user to persist.");
        }
        return userRepository.persist(user);
    }

    public User merge(User user, String login) throws NoSuchAlgorithmException {
        if (login == null) {
            throw new NullPointerException("The login is null, merging failed.");
        }
        if (login.isEmpty()) {
            throw new IllegalArgumentException("The login is empty, merging failed.");
        }
        if (user == null) {
            throw new NullPointerException("There is no user to merge.");
        }
        if (user.getLogin().isEmpty()) {
            throw new IllegalArgumentException("The login is empty, merging failed.");
        }
        User updatingUser = userRepository.findOne(login);
        if (updatingUser == null) {
            return userRepository.persist(user);
        }
        return userRepository.merge(user, login);
    }

    public User remove(User user) {
        if (user == null) {
            throw new NullPointerException("There is no user to remove");
        }
        return userRepository.remove(user);
    }

    public void removeAll() {
        userRepository.removeAll();
    }

}
