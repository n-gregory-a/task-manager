package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.constant.FieldConstant;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class UserRepository extends AbstractRepository<User> implements IUserRepository {

    public UserRepository(@NotNull Connection connection) {
        super(connection);
    }

    @Nullable
    private User fetch(@Nullable final ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        @NotNull final User user = new User();
        user.setId(resultSet.getString(FieldConstant.ID));
        user.setName(resultSet.getString(FieldConstant.NAME));
        user.setPassword(resultSet.getString(FieldConstant.PASSWORD_HASH));
        user.setRole(RoleType.valueOf(resultSet.getString(FieldConstant.ROLE)));
        return user;
    }

    @NotNull
    @Override
    public List<User> findAll() throws SQLException {
        @NotNull final String query = "SELECT * FROM `app_user`";
        @NotNull final Statement statement = getConnection().createStatement();
        @NotNull final ResultSet resultSet = statement.executeQuery(query);
        @NotNull final List<User> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @Nullable
    @Override
    public User findOne(@NotNull final String name) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `app_user` " +
                        "WHERE `name` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, name);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final boolean hasNext = resultSet.next();
        if (!hasNext) {
            return null;
        }
        return fetch(resultSet);
    }

    @Nullable
    @Override
    public User findOneById(@NotNull String id) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `app_user` " +
                        "WHERE `id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, id);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final boolean hasNext = resultSet.next();
        if (!hasNext) {
            return null;
        }
        return fetch(resultSet);
    }

    @NotNull
    @Override
    public  User persist(@NotNull final User user) throws SQLException {
        @NotNull final String query =
                "INSERT INTO `app_user` " +
                "(`id`, `name`, `password_hash`, `role`) " +
                "VALUES (?, ?, ?, ?)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        statement.setString(4, String.valueOf(user.getRole()));
        statement.execute();
        return user;
    }

    @NotNull
    @Override
    public  User merge(@NotNull final User user) throws SQLException {
        @NotNull String query =
                "UPDATE `app_user` " +
                "SET `id` = ?, `name` = ?, " +
                "`password_hash` = ?, `role` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        statement.setString(4, String.valueOf(user.getRole()));
        statement.execute();
        return user;
    }

    @NotNull
    @Override
    public  User remove(@NotNull final User user) throws SQLException {
        @NotNull final String query = "DELETE FROM `app_user` WHERE `id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, user.getId());
        statement.execute();
        return user;
    }

    @Override
    public void removeAll() throws SQLException {
        @NotNull final String query = "DELETE * FROM `app_user`";
        @NotNull final Statement statement = getConnection().createStatement();
        statement.execute(query);
    }

}
