package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.sql.SQLException;
import java.util.List;

public interface ISessionRepository {

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

}
