package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionRepository {

    @NotNull
    List<Session> findAll();

    @Nullable
    Session findOne(@NotNull final String id);

    void persist(@NotNull final Session session);

    void merge(@NotNull final Session session);

    void remove(@NotNull final String id);

    void removeAll();

}
