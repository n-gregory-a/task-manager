package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public interface IUserService extends IService<User> {

    User getCurrentUser();

    void setCurrentUser(final User currentUser);

    User createUser(final RoleType role);

    boolean isRoleAdmin();

    String getCurrentUserId();

}
