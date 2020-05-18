package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionService extends IService<Session> {

    void open(@NotNull final String login, @NotNull final String password);

    void close(@NotNull final Session session);

    void closeAll(@NotNull final Session session);

    @NotNull
    List<Session> getListSession(@NotNull final Session session);

    void validate(@NotNull final Session session);

    Session sign(@NotNull final Session session);

    boolean isValid(@NotNull final Session session);

}
