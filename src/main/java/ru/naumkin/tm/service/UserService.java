package ru.naumkin.tm.service;

import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.entity.User;

public class UserService extends AbstractService<User> {

    public UserService(IRepository<User> repository) {
        super(repository);
    }

}
