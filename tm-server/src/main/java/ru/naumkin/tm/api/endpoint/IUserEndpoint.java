package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IUserEndpoint {

    @NotNull
    @WebMethod
    List<User> findAllUsers();

    @NotNull
    @WebMethod
    User findOneUser(@NotNull final String name);

    @Nullable
    @WebMethod
    User persistUser(@NotNull final User user);

    @Nullable
    @WebMethod
    User mergeUser(
            @NotNull final Session session,
            @NotNull final User user,
            @NotNull final String name);

    @Nullable
    @WebMethod
    User removeUser(@NotNull final Session session, @NotNull final User user);

    @WebMethod
    void removeAllUser(@NotNull final Session session);

    @WebMethod
    void loadUser(@NotNull final Session session, @NotNull final User[] users);

    @Nullable
    @WebMethod
    User getCurrentUser();

    @WebMethod
    void setCurrentUser(@NotNull final User currentUser);

    @NotNull
    @WebMethod
    User createUser(@NotNull final RoleType role);

    @WebMethod
    boolean isRoleAdmin(@NotNull final Session session, @NotNull final User user);

    @Nullable
    @WebMethod
    String getCurrentUserId(@NotNull final Session session);

}
