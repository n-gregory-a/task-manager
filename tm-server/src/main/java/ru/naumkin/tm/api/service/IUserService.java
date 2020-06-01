package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    boolean isRoleAdmin(@NotNull final String id);

    @NotNull
    List<User> findAll();

    @NotNull
    User findOne(@NotNull final String name);

    @Nullable
    User findOneById(@NotNull final String id);

    void persist(@NotNull final User user);

    void merge(@NotNull final User user);

    void remove(@NotNull final User user);

    void removeAll();

}
