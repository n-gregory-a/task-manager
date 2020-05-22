package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class UserService extends AbstractService<User> implements IUserService {

    public UserService(@NotNull IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public boolean isRoleAdmin(@Nullable final User user) {
        if (user == null) {
            throw new RuntimeException();
        }
        return user.getRole() == RoleType.ADMINISTRATOR;
    }

    @NotNull
    @Override
    public List<User> findAll() throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new UserRepository(connection).findAll();
    }

    @NotNull
    @Override
    public User findOne(@Nullable final String name) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final User user = new UserRepository(connection).findOne(name);
        if (user == null) {
            throw new NoUserWithSuchLoginException(name);
        }
        return user;
    }

    @NotNull
    @Override
    public User findOneById(@Nullable final String id) throws SQLException {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final User user = new UserRepository(connection).findOneById(id);
        if (user == null) {
            throw new NoUserWithSuchIdException(id);
        }
        return user;
    }

    @NotNull
    @Override
    public User persist(@Nullable final User user) throws SQLException {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new UserRepository(connection).persist(user);
    }

    @NotNull
    @Override
    public User merge(@Nullable final User user) throws SQLException {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new UserRepository(connection).merge(user);
    }

    @NotNull
    @Override
    public User remove(@Nullable final User user) throws SQLException {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new UserRepository(connection).remove(user);
    }

    @Override
    public void removeAll() throws SQLException {
        @NotNull final Connection connection = getConnection();
        new UserRepository(connection).removeAll();
    }

}
