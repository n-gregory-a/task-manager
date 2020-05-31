package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionRepository {

    @NotNull
    List<Session> findAll() throws Exception;

    @Nullable
    Session findOne(@NotNull final String id) throws Exception;

    void persist(@NotNull final Session session) throws Exception;

    void merge(@NotNull final Session session) throws Exception;

    void remove(@NotNull final String id) throws Exception;

    void removeAll() throws Exception;

}
