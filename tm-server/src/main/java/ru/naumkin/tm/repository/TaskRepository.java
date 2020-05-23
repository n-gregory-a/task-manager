package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.constant.FieldConstant;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.enumerated.Status;
import ru.naumkin.tm.util.DateFormatter;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public final class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    public TaskRepository(@NotNull Connection connection) {
        super(connection);
    }

    @Nullable
    private Task fetch(@Nullable final ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        @NotNull final Task task = new Task();
        task.setId(resultSet.getString(FieldConstant.ID));
        task.setName(resultSet.getString(FieldConstant.NAME));
        task.setDescription(resultSet.getString(FieldConstant.DESCRIPTION));
        task.setDateStart(resultSet.getDate(FieldConstant.DATE_START));
        task.setDateFinish(resultSet.getDate(FieldConstant.DATE_FINISH));
        task.setProjectId(resultSet.getString(FieldConstant.PROJECT_ID));
        task.setUserId(resultSet.getString(FieldConstant.USER_ID));
        task.setStatus(Status.valueOf(resultSet.getString(FieldConstant.STATUS)));
        return task;
    }

    @Override
    public @NotNull List<Task> findAll() throws SQLException {
        @NotNull final String query = "SELECT * FROM `task`";
        @NotNull final Statement statement = getConnection().createStatement();
        @NotNull final ResultSet resultSet = statement.executeQuery(query);
        @NotNull final List<Task> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> findAll(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `task` " +
                "WHERE `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final List<Task> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @Nullable
    @Override
    public Task findOne(
            @NotNull final String userId,
            @NotNull final String name
    ) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `task` " +
                "WHERE `name` = ? " +
                "AND `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final boolean hasNext = resultSet.next();
        if (!hasNext) {
            return null;
        }
        return fetch(resultSet);
    }

    @NotNull
    @Override
    public Task persist(@NotNull final Task task) throws SQLException {
        @NotNull final String query =
                "INSERT INTO `task` " +
                "(`id`, `name`, `description`, `date_start`, `date_finish`, `project_id`, `user_id`, `status`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, task.getId());
        statement.setString(2, task.getName());
        statement.setString(3, task.getDescription());
        statement.setDate(4, DateFormatter.convertToSqlDate(task.getDateStart()));
        statement.setDate(5, DateFormatter.convertToSqlDate(task.getDateFinish()));
        statement.setString(6, task.getProjectId());
        statement.setString(7, task.getUserId());
        statement.setString(8, String.valueOf(task.getStatus()));
        statement.execute();
        return task;
    }

    @NotNull
    @Override
    public Task merge(@NotNull final Task task) throws SQLException {
        @NotNull String query =
                "UPDATE `project` " +
                "SET `id` = ?, `name` = ?, `description` = ?, `date_start` = ?," +
                "`date_finish` = ?, `project_id` = ?, `user_id` = ?, `status` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, task.getId());
        statement.setString(2, task.getName());
        statement.setString(3, task.getDescription());
        statement.setDate(4, DateFormatter.convertToSqlDate(task.getDateStart()));
        statement.setDate(5, DateFormatter.convertToSqlDate(task.getDateFinish()));
        statement.setString(6, task.getUserId());
        statement.setString(7, String.valueOf(task.getStatus()));
        statement.execute();
        return task;
    }

    @NotNull
    @Override
    public Task remove(
            @NotNull final String userId,
            @NotNull final Task task
    ) throws SQLException {
        @NotNull final String query =
                "DELETE FROM `task` " +
                "WHERE `id` = ? " +
                "AND `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, task.getId());
        statement.setString(2, task.getUserId());
        statement.execute();
        return task;
    }

    @Override
    public void removeAll(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "DELETE FROM `task` " +
                "WHERE `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        statement.execute();
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `task` " +
                "WHERE `user_id` = ? " +
                "ORDER BY `date_start`";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final List<Task> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `task` " +
                "WHERE `user_id` = ? " +
                "ORDER BY `date_finish`";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final List<Task> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `task` " +
                "WHERE `user_id` = ? " +
                "ORDER BY FIELD(`status`, `PLANNED`, `IN_PROGRESS`, `COMPLETED`)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        @NotNull final List<Task> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @NotNull final String userId,
            @NotNull final String name
    ) throws SQLException {
        @NotNull final List<Task> all = findAll(userId);
        @NotNull final List<Task> result = new LinkedList<>();
        for (@NotNull final Task task: all) {
            if (task.getName().contains(name)) {
                result.add(task);
            }
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
            @NotNull final String userId,
            @NotNull final String description
    ) throws SQLException {
        @NotNull final List<Task> all = findAll(userId);
        @NotNull final List<Task> result = new LinkedList<>();
        for (@NotNull final Task task: all) {
            if (task.getDescription().contains(description)) {
                result.add(task);
            }
        }
        return result;
    }

}
