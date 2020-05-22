package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface IUserEndpoint {

    @NotNull
    @WebMethod
    List<User> findAllUsers() throws SQLException;

    @Nullable
    @WebMethod
    User findOneUser(@NotNull final String name) throws SQLException;

    @Nullable
    @WebMethod
    User persistUser(@NotNull final User user) throws SQLException;

    @Nullable
    @WebMethod
    User mergeUser(
            @NotNull final Session session,
            @NotNull final User user,
            @NotNull final String name) throws SQLException;

    @Nullable
    @WebMethod
    User removeUser(@NotNull final Session session, @NotNull final User user) throws SQLException;

    @WebMethod
    void removeAllUser(@NotNull final Session session) throws SQLException;

    @WebMethod
    boolean isRoleAdmin(@NotNull final Session session, @NotNull final String id) throws SQLException;


}
