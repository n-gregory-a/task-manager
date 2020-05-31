package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface IUserRepository {

    @NotNull
    List<User> findAll() throws Exception;

    @Nullable
    User findOne(@NotNull final String name) throws Exception;

    @Nullable
    User findOneById(@NotNull final String id) throws Exception;

    void persist(@NotNull final User user) throws Exception;

    void merge(@NotNull final User user) throws Exception;

    void remove(@NotNull final User user) throws Exception;

    void removeAll() throws Exception;

}
