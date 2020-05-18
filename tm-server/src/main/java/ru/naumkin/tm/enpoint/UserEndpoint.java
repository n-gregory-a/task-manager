package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IUserEndpoint")
public final class UserEndpoint implements IUserEndpoint {

    @NotNull private IUserService userService;

    public UserEndpoint(@NotNull final IUserService userService) {
        this.userService = userService;
    }

    @NotNull
    @Override
    @WebMethod
    public List<User> findAllUsers() {
        return new LinkedList<>(userService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public User findOneUser(@Nullable final String name) {
        return userService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public User persistUser(@Nullable final User user) {
        return userService.persist(user);
    }

    @Nullable
    @Override
    @WebMethod
    public User mergeUser(
            @Nullable final User user,
            @Nullable final String name
    ) {
        return userService.merge(user, name);
    }

    @Nullable
    @Override
    @WebMethod
    public User removeUser(@Nullable final User user) {
        return userService.remove(user);
    }

    @Override
    @WebMethod
    public void removeAllUser() {
        userService.removeAll();
    }

    @Override
    @WebMethod
    public void loadUser(@NotNull final User[] users) {
        userService.persist(users);
    }

    @Nullable
    @Override
    @WebMethod
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @Override
    @WebMethod
    public void setCurrentUser(@Nullable final User currentUser) {
        userService.setCurrentUser(currentUser);
    }

    @NotNull
    @Override
    @WebMethod
    public User createUser(@NotNull final RoleType role) {
        return userService.createUser(role);
    }

    @Override
    @WebMethod
    public boolean isRoleAdmin(@NotNull final User user) {
        return userService.isRoleAdmin(user);
    }

    @Nullable
    @Override
    @WebMethod
    public String getCurrentUserId() {
        return userService.getCurrentUserId();
    }

}
