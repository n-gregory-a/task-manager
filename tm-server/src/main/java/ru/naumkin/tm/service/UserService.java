package ru.naumkin.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

@NoArgsConstructor
public final class UserService extends AbstractService<User> implements IUserService {

    @Getter
    @Setter
    @Nullable
    private User currentUser;

    public UserService(@NotNull final IRepository<User> repository) {
        super(repository);
    }

    @NotNull
    @Override
    public User createUser(@Nullable final RoleType role) {
        if (role == null) {
            throw new RuntimeException();
        }
        @NotNull User user = new User();
        if (role == RoleType.ADMINISTRATOR) {
            user.setName("admin");
            user.setPassword(HashGenerator.getHash("admin"));
            user.setRole(role);
            persist(user);
            return user;
        }
        user.setName("user");
        persist(user);
        return user;
    }

    @Override
    public boolean isRoleAdmin(User user) {
        if (user == null) {
            throw new RuntimeException();
        }
        return user.getRole() == RoleType.ADMINISTRATOR;
    }

    @NotNull
    @Override
    public String getCurrentUserId() {
        if (currentUser == null) {
            throw new RuntimeException();
        }
        return currentUser.getId();
    }

}
