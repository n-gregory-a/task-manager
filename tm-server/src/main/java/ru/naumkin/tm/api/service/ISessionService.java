package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

import java.sql.SQLException;
import java.util.List;

public interface ISessionService extends IService<Session> {

    @NotNull
    List<Session> findAll() throws SQLException;

    @Nullable
    Session findOne(@NotNull final String id) throws SQLException;

    @Nullable
    Session persist(@NotNull final Session session) throws SQLException;

    @Nullable
    Session merge(@NotNull final Session session) throws SQLException;

    @Nullable
    Session remove(@NotNull final Session session) throws SQLException;

    void removeAll() throws SQLException;

    Session open(@NotNull final String login, @NotNull final String password) throws SQLException;

    void close(@NotNull final Session session) throws SQLException;

    void closeAll(@NotNull final Session session) throws SQLException;

    @NotNull
    List<Session> getListSession(@NotNull final Session session) throws SQLException;

    @Nullable
    User getUser(@NotNull final Session session) throws SQLException;

    void validate(@NotNull final Session session) throws SQLException;

    Session sign(@NotNull final Session session);

}
