package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public interface IUserService extends IService<User> {

    User createUser(RoleType role);

    boolean isRoleAdmin(User user);

}
