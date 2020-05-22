package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService extends IService<User> {

    boolean isRoleAdmin(@NotNull final String id) throws SQLException;

    @NotNull
    List<User> findAll() throws SQLException;

    @Nullable
    User findOne(@NotNull final String name) throws SQLException;

    @Nullable
    User findOneById(@NotNull final String id) throws SQLException;

    @Nullable
    User persist(@NotNull final User user) throws SQLException;

    @Nullable
    User merge(@NotNull final User user) throws SQLException;

    @Nullable
    User remove(@NotNull final User user) throws SQLException;

    void removeAll() throws SQLException;

}
