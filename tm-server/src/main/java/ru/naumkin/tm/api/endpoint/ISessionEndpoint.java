package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface ISessionEndpoint {

    @NotNull
    @WebMethod
    List<Session> findAllSessions(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    Session findOneSession(@NotNull final Session session, @NotNull final String name) throws SQLException;

    @Nullable
    @WebMethod
    Session persistSession(@NotNull final Session session) throws SQLException;

    @Nullable
    @WebMethod
    Session mergeSession(@NotNull final Session session, @NotNull final String name) throws SQLException;

    @Nullable
    @WebMethod
    Session removeSession(@NotNull final Session session) throws SQLException;

    @WebMethod
    void removeAllSessions(@NotNull final Session session) throws SQLException;

    @WebMethod
    Session open(
            @NotNull final String login,
            @NotNull final String password) throws SQLException;

    @WebMethod
    void close(@NotNull final Session session) throws SQLException;

    @WebMethod
    void closeAll(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Session> getListSession(@NotNull final Session session) throws SQLException;

    @WebMethod
    void validate(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    Session sign(@NotNull final Session session);

}
