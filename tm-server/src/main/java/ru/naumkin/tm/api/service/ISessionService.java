package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface ISessionService extends IService<Session> {

    @NotNull
    List<Session> findAll() throws Exception;

    @Nullable
    Session findOne(@NotNull final String id) throws Exception;

    void persist(@NotNull final Session session) throws Exception;

    void merge(@NotNull final Session session) throws Exception;

    void remove(@NotNull final Session session) throws Exception;

    void removeAll() throws Exception;

    Session open(@NotNull final String login, @NotNull final String password) throws Exception;

    void close(@NotNull final Session session) throws Exception;

    void closeAll(@NotNull final Session session) throws Exception;

    @NotNull
    List<Session> getListSession(@NotNull final Session session) throws Exception;

    @Nullable
    User getUser(@NotNull final Session session) throws Exception;

    void validate(@NotNull final Session session) throws Exception;

    Session sign(@NotNull final Session session);

}
