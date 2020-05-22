package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;

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
    public List<User> findAllUsers() throws Exception {
        return new LinkedList<>(userService.findAll());
    }

    @Nullable
    @Override
    @WebMethod
    public User findOneUser(
            @Nullable final String name
    ) throws Exception {
        return userService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public User persistUser(
            @NotNull final User user
    ) throws Exception {
        return userService.persist(user);
    }

    @Nullable
    @Override
    @WebMethod
    public User mergeUser(
            @NotNull final Session session,
            @NotNull final User user,
            @Nullable final String name
    ) throws Exception {
        validate(session);
        return userService.merge(user);
    }

    @Nullable
    @Override
    @WebMethod
    public User removeUser(
            @NotNull final Session session,
            @NotNull final User user
    ) throws Exception {
        validate(session);
        return userService.remove(user);
    }

    @Override
    @WebMethod
    public void removeAllUser(@NotNull final Session session) throws Exception {
        validate(session);
        userService.removeAll();
    }

    @Override
    @WebMethod
    public boolean isRoleAdmin(
            @NotNull final Session session,
            @NotNull final String id
    ) throws Exception {
        validate(session);
        return userService.isRoleAdmin(id);
    }


}
