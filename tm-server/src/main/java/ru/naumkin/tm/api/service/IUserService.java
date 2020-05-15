package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public interface IUserService extends IService<User> {

    @Nullable
    User getCurrentUser();

    void setCurrentUser(@Nullable final User currentUser);

    @NotNull
    User createUser(@NotNull final RoleType role);

    boolean isRoleAdmin(User user);

    @Nullable
    String getCurrentUserId();

}
