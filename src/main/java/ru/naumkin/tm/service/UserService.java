package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.NoUserWithSuchLoginException;
import ru.naumkin.tm.error.UserIsNullException;
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
            throw new NameIsNullException();
        }
        if (login.isEmpty()) {
            throw new NameIsEmptyException();
        }
        User user = userRepository.findOne(login);
        if (user == null) {
            throw new NoUserWithSuchLoginException(login);
        }
        return user;
    }

    public User persist(User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        return userRepository.persist(user);
    }

    public User merge(User user, String login) throws NoSuchAlgorithmException {
        if (login == null) {
            throw new NameIsNullException();
        }
        if (login.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (user == null) {
            throw new UserIsNullException();
        }
        if (user.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        User updatingUser = userRepository.findOne(login);
        if (updatingUser == null) {
            return userRepository.persist(user);
        }
        return userRepository.merge(user, login);
    }

    public User remove(User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        return userRepository.remove(user);
    }

    public void removeAll() {
        userRepository.removeAll();
    }

}
