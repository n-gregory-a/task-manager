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
    List<Session> findAllSessions(@NotNull final Session session) throws Exception;

    @Nullable
    @WebMethod
    Session findOneSession(@NotNull final Session session, @NotNull final String name) throws Exception;

    @WebMethod
    void persistSession(@NotNull final Session session) throws Exception;

    @WebMethod
    void mergeSession(@NotNull final Session session, @NotNull final String name) throws Exception;

    @WebMethod
    void removeSession(@NotNull final Session session) throws Exception;

    @WebMethod
    void removeAllSessions(@NotNull final Session session) throws Exception;

    @WebMethod
    Session open(
            @NotNull final String login,
            @NotNull final String password) throws Exception;

    @WebMethod
    void validate(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    Session sign(@NotNull final Session session);

}
