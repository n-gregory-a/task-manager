package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ISessionRepository;
import ru.naumkin.tm.constant.FieldConstant;
import ru.naumkin.tm.entity.Session;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SessionRepository extends AbstractRepository<Session> implements ISessionRepository {

    public SessionRepository(@NotNull Connection connection) {
        super(connection);
    }

    @Nullable
    private Session fetch(@Nullable final ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        @NotNull final Session session = new Session();
        session.setId(resultSet.getString(FieldConstant.ID));
        session.setName(resultSet.getString(FieldConstant.NAME));
        session.setTimestamp(resultSet.getLong(FieldConstant.TIMESTAMP));
        session.setUserId(resultSet.getString(FieldConstant.USER_ID));
        session.setSignature(resultSet.getString(FieldConstant.SIGNATURE));
        return session;
    }

    @Override
    public @NotNull List<Session> findAll() throws SQLException {
        @NotNull final String query = "SELECT * FROM `session`";
        @NotNull final Statement statement = getConnection().createStatement();
        @NotNull final ResultSet resultSet = statement.executeQuery(query);
        @NotNull final List<Session> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @Nullable
    @Override
    public Session findOne(@NotNull final String id) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `session` " +
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
    public Session persist(@NotNull final Session session) throws SQLException {
        @NotNull final String query =
                "INSERT INTO `session` " +
                "(`id`, `name`, `timestamp`, `user_id`, `signature`) " +
                "VALUES (?, ?, ?, ?, ?)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, session.getId());
        statement.setString(2, session.getName());
        statement.setLong(3, session.getTimestamp());
        statement.setString(4, session.getUserId());
        statement.setString(5, session.getSignature());
        statement.execute();
        return session;
    }

    @NotNull
    @Override
    public Session merge(@NotNull final Session session) throws SQLException {
        @NotNull String query =
                "UPDATE `session` " +
                "SET `id` = ?, `name` = ?, `timestamp` = ?, " +
                "`user_id` = ?, `signature` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, session.getId());
        statement.setString(2, session.getName());
        statement.setLong(3, session.getTimestamp());
        statement.setString(4, session.getUserId());
        statement.setString(5, session.getSignature());
        statement.execute();
        return session;
    }

    @NotNull
    @Override
    public Session remove(@NotNull final Session session) throws SQLException {
        @NotNull final String query = "DELETE FROM `session` WHERE `id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, session.getId());
        statement.execute();
        return session;
    }

    @Override
    public void removeAll() throws SQLException {
        @NotNull final String query = "DELETE * FROM `session`";
        @NotNull final Statement statement = getConnection().createStatement();
        statement.execute(query);
    }

}
