package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IUserEndpoint")
public final class UserEndpoint extends AbstractEndpoint implements IUserEndpoint {

    @NotNull private IUserService userService;

    public UserEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final IUserService userService) {
        super(sessionService);
        this.userService = userService;
    }

    @NotNull
    @Override
    @WebMethod
    public List<User> findAllUsers(@Nullable final Session session) {
        validate(session);
        return new LinkedList<>(userService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public User findOneUser(
            @Nullable final Session session,
            @Nullable final String name
    ) {
        validate(session);
        return userService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public User persistUser(
            @Nullable final Session session,
            @Nullable final User user
    ) {
        validate(session);
        return userService.persist(user);
    }

    @Nullable
    @Override
    @WebMethod
    public User mergeUser(
            @Nullable final Session session,
            @Nullable final User user,
            @Nullable final String name
    ) {
        validate(session);
        return userService.merge(user, name);
    }

    @Nullable
    @Override
    @WebMethod
    public User removeUser(
            @Nullable final Session session,
            @Nullable final User user
    ) {
        validate(session);
        return userService.remove(user);
    }

    @Override
    @WebMethod
    public void removeAllUser(@Nullable final Session session) {
        validate(session);
        userService.removeAll();
    }

    @Override
    @WebMethod
    public void loadUser(
            @Nullable final Session session,
            @NotNull final User[] users
    ) {
        validate(session);
        userService.persist(users);
    }

    @Nullable
    @Override
    @WebMethod
    public User getCurrentUser(@Nullable final Session session) {
        validate(session);
        return userService.getCurrentUser();
    }

    @Override
    @WebMethod
    public void setCurrentUser(
            @Nullable final Session session,
            @Nullable final User currentUser
    ) {
        validate(session);
        userService.setCurrentUser(currentUser);
    }

    @NotNull
    @Override
    @WebMethod
    public User createUser(
            @Nullable final Session session,
            @NotNull final RoleType role
    ) {
        validate(session);
        return userService.createUser(role);
    }

    @Override
    @WebMethod
    public boolean isRoleAdmin(
            @Nullable final Session session,
            @NotNull final User user
    ) {
        validate(session);
        return userService.isRoleAdmin(user);
    }

    @Nullable
    @Override
    @WebMethod
    public String getCurrentUserId(@Nullable final Session session) {
        validate(session);
        return userService.getCurrentUserId();
    }

}
