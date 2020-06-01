package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionService extends IService<Session> {

    @NotNull
    List<Session> findAll();

    @Nullable
    Session findOne(@NotNull final String id);

    void persist(@NotNull final String sessionToken) throws Exception;

    void merge(@NotNull final String sessionToken) throws Exception;

    void remove(@NotNull final String sessionToken) throws Exception;

    void removeAll();

    @NotNull
    String open(@NotNull final String login, @NotNull final String password) throws Exception;

    @NotNull
    String getUserId(@NotNull final String sessionToken) throws Exception;

    void validate(@NotNull final String sessionToken) throws Exception;

}
