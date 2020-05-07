package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.error.RoleTypeIsNullException;
import ru.naumkin.tm.error.UserIsNullException;
import ru.naumkin.tm.util.HashGenerator;

public final class UserService extends AbstractService<User> implements IUserService {

    private User currentUser;

    public UserService(final IRepository<User> repository) {
        super(repository);
    }

    @Override
    public @Nullable User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(final @Nullable User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public @NotNull User createUser(final @Nullable RoleType role) {
        if (role == null) {
            throw new RoleTypeIsNullException();
        }
        @NotNull User user = new User();
        if (role == RoleType.ADMINISTRATOR) {
            user.setName("admin");
            user.setPassword(HashGenerator.getHash("MeG@$tr0nG@dmiN$p@$$w0rD"));
            user.setRole(role);
            persist(user);
            return user;
        }
        user.setName("user");
        persist(user);
        return user;
    }

    @Override
    public boolean isRoleAdmin() {
        return currentUser.getRole() == RoleType.ADMINISTRATOR;
    }

    @Override
    public @NotNull String getCurrentUserId() {
        if (currentUser == null) {
            throw new UserIsNullException();
        }
        return getCurrentUser().getId();
    }

}
