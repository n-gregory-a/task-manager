package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ISessionEndpoint {

    @NotNull
    @WebMethod
    List<Session> findAllSessions(@Nullable final Session session);

    @NotNull
    @WebMethod
    Session findOneSession(@Nullable final Session session, @Nullable final String name);

    @Nullable
    @WebMethod
    Session persistSession(@Nullable final Session session);

    @Nullable
    @WebMethod
    Session mergeSession(@Nullable final Session session, @Nullable final String name);

    @Nullable
    @WebMethod
    Session removeSession(@Nullable final Session session);

    @WebMethod
    void removeAllSessions(@Nullable final Session session);

    @WebMethod
    void persistSession(@Nullable final Session session, @NotNull final Session[] sessions);

    @WebMethod
    void open(
            @Nullable final Session session,
            @NotNull final String login,
            @NotNull final String password);

    @WebMethod
    void close(@NotNull final Session session);

    @WebMethod
    void closeAll(@NotNull final Session session);

    @NotNull
    @WebMethod
    List<Session> getListSession(@NotNull final Session session);

    @WebMethod
    void validate(@NotNull final Session session);

    @WebMethod
    void validate(@NotNull final Session session, @NotNull final RoleType role);

    @NotNull
    @WebMethod
    Session sign(@NotNull final Session session);

    @WebMethod
    boolean isValid(@NotNull final Session session);
    
}
