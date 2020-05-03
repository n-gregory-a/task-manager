package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.User;

public class UserRepository extends AbstractRepository<User> {

    @Override
    public User merge(User user, String name) {
        User updatingUser = map.get(name);
        updatingUser.setName(name);
        updatingUser.setPassword(user.getPassword());
        updatingUser.setRole(user.getRole());
        map.remove(name);
        return map.put(updatingUser.getName(), updatingUser);
    }
}
