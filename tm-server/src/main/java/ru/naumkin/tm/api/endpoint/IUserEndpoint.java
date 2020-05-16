package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
    User findOneUser(@Nullable final String name);

    @Nullable
    @WebMethod
    User persistUser(@Nullable final User user);

    @Nullable
    @WebMethod
    User mergeUser(@Nullable final User user, @Nullable final String name);

    @Nullable
    @WebMethod
    User removeUser(@Nullable final User user);

    @WebMethod
    void removeAllUser();

    @WebMethod
    void loadUser(@NotNull final User[] users);

    @Nullable
    @WebMethod
    User getCurrentUser();

    @WebMethod
    void setCurrentUser(@Nullable final User currentUser);

    @NotNull
    @WebMethod
    User createUser(@NotNull final RoleType role);

    @WebMethod
    boolean isRoleAdmin(@NotNull final User user);

    @Nullable
    @WebMethod
    String getCurrentUserId();

}