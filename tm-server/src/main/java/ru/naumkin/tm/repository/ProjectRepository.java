package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.constant.FieldConstant;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.enumerated.Status;
import ru.naumkin.tm.util.DateFormatter;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public final class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

    public ProjectRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Nullable
    private Project fetch(@Nullable final ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        @NotNull final Project project = new Project();
        project.setId(resultSet.getString(FieldConstant.ID));
        project.setName(resultSet.getString(FieldConstant.NAME));
        project.setDescription(resultSet.getString(FieldConstant.DESCRIPTION));
        project.setDateStart(resultSet.getDate(FieldConstant.DATE_START));
        project.setDateFinish(resultSet.getDate(FieldConstant.DATE_FINISH));
        project.setUserId(resultSet.getString(FieldConstant.USER_ID));
        project.setStatus(Status.valueOf(resultSet.getString(FieldConstant.STATUS)));
        return project;
    }

    @NotNull
    @Override
    public List<Project> findAll() throws SQLException {
        @NotNull final String query = "SELECT * FROM `project`";
        @NotNull final Statement statement = getConnection().createStatement();
        @NotNull final ResultSet resultSet = statement.executeQuery(query);
        @NotNull final List<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        statement.close();
        return result;
    }

    @NotNull
    @Override
    public List<Project> findAll(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `project` " +
                "WHERE `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        statement.close();
        @NotNull final List<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        statement.close();
        return result;
    }

    @Nullable
    @Override
    public Project findOne(
            @NotNull final String userId,
            @NotNull final String name
    ) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `project` " +
                "WHERE `name` = ? " +
                "AND `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        statement.close();
        @NotNull final boolean hasNext = resultSet.next();
        if (!hasNext) {
            return null;
        }
        return fetch(resultSet);
    }

    @NotNull
    @Override
    public Project persist(@NotNull final Project project) throws SQLException {
        @NotNull final String query =
                "INSERT INTO `project` " +
                "(`id`, `name`, `description`, `date_start`, `date_finish`, `user_id`, `status`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getName());
        statement.setString(3, project.getDescription());
        statement.setDate(4, DateFormatter.convertToSqlDate(project.getDateStart()));
        statement.setDate(5, DateFormatter.convertToSqlDate(project.getDateFinish()));
        statement.setString(6, project.getUserId());
        statement.setString(7, String.valueOf(project.getStatus()));
        statement.execute();
        statement.close();
        return project;
    }

    @NotNull
    @Override
    public Project merge(@NotNull final Project project) throws SQLException {
        @NotNull String query =
                "UPDATE `project` " +
                "SET `id` = ?, `name` = ?, `description` = ?, `date_start` = ?," +
                "`date_finish` = ?, `user_id` = ?, `status` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getName());
        statement.setString(3, project.getDescription());
        statement.setDate(4, DateFormatter.convertToSqlDate(project.getDateStart()));
        statement.setDate(5, DateFormatter.convertToSqlDate(project.getDateFinish()));
        statement.setString(6, project.getUserId());
        statement.setString(7, String.valueOf(project.getStatus()));
        statement.execute();
        statement.close();
        return project;
    }

    @NotNull
    @Override
    public Project remove(
            @NotNull final String userId,
            @NotNull final Project project
    ) throws SQLException {
        @NotNull String query =
                "DELETE FROM `project` " +
                "WHERE `id` = ? AND `user_id` = ?";
        @NotNull PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getUserId());
        statement.execute();
        query = "DELETE FROM `task` " +
                "WHERE `project_id` = ? " +
                "AND `user_id` = ?";
        statement = getConnection().prepareStatement(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getUserId());
        statement.execute();
        statement.close();
        return project;
    }

    @Override
    public void removeAll(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "DELETE * FROM `project` " +
                "WHERE `user_id` = ?";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        statement.execute();
        statement.close();
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `project` " +
                "WHERE `user_id` = ? " +
                "ORDER BY `date_start`";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        statement.close();
        @NotNull final List<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `project` " +
                "WHERE `user_id` = ? " +
                "ORDER BY `date_finish`";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        statement.close();
        @NotNull final List<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@NotNull final String userId) throws SQLException {
        @NotNull final String query =
                "SELECT * FROM `project` " +
                "WHERE `user_id` = ? " +
                "ORDER BY FIELD(`status`, `PLANNED`, `IN_PROGRESS`, `COMPLETED`)";
        @NotNull final PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setString(1, userId);
        @NotNull final ResultSet resultSet = statement.executeQuery();
        statement.close();
        @NotNull final List<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(fetch(resultSet));
        }
        return result;
    }

    @NotNull
    @Override
    public List<Project> sortByName(
            @NotNull final String userId,
            @NotNull final String name
    ) throws SQLException {
        @NotNull final List<Project> all = findAll(userId);
        @NotNull final List<Project> result = new LinkedList<>();
        for (@NotNull final Project project: all) {
            if (project.getName().contains(name)) {
                result.add(project);
            }
        }
        return result;
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @NotNull final String userId,
            @NotNull final String description
    ) throws SQLException {
        @NotNull final List<Project> all = findAll(userId);
        @NotNull final List<Project> result = new LinkedList<>();
        for (@NotNull final Project project: all) {
            if (project.getDescription().contains(description)) {
                result.add(project);
            }
        }
        return result;
    }

}