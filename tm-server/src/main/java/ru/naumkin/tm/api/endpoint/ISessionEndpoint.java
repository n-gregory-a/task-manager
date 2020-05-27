package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ISessionEndpoint {

    @NotNull
    @WebMethod
    List<Session> findAllSessions(@NotNull final String sessionToken) throws Exception;

    @Nullable
    @WebMethod
    Session findOneSession(@NotNull final String sessionToken, @NotNull final String name) throws Exception;

    @WebMethod
    void persistSession(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void mergeSession(@NotNull final String sessionToken, @NotNull final String name) throws Exception;

    @WebMethod
    void removeSession(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void removeAllSessions(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    String open(
            @NotNull final String login,
            @NotNull final String password) throws Exception;

    @WebMethod
    void validate(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    String getUserId(@NotNull final String sessionToken) throws Exception;

}
