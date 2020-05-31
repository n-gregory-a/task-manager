package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface IUserRepository {

    @NotNull
    List<User> findAll();

    @Nullable
    User findOne(@NotNull final String name);

    @Nullable
    User findOneById(@NotNull final String id);

    void persist(@NotNull final User user);

    void merge(@NotNull final User user);

    void remove(@NotNull final String id);

    void removeAll();

}
