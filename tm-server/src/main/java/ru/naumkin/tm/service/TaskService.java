package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.TaskRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class TaskService extends AbstractService<Task> implements ITaskService {

    public TaskService(@NotNull IPropertyService propertyService) {
        super(propertyService);
    }

    @NotNull
    @Override
    public List<Task> findAll(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).findAll(userId);
    }

    @NotNull
    @Override
    public Task findOne(
            @Nullable final String userId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Task task =
                new TaskRepository(connection).findOne(userId, name);
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    @NotNull
    @Override
    public Task persist(@Nullable final Task task) throws SQLException {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).persist(task);
    }

    @NotNull
    @Override
    public Task merge(@Nullable final Task task) throws SQLException {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).merge(task);
    }

    @NotNull
    @Override
    public Task remove(
            @Nullable final String userId,
            @Nullable final Task task
    ) throws SQLException {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Task toRemove =
                new TaskRepository(connection).remove(userId, task);
        if (toRemove == null) {
            throw new TaskIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        new TaskRepository(connection).removeAll(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDateStart(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDateFinish(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByStatus(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @Nullable final String userId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByName(userId, name);
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
            @Nullable final String userId,
            @Nullable final String description
    ) throws SQLException {
        if (description == null) {
            throw new DescriptionIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (description.isEmpty()) {
            throw new DescriptionIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDescription(userId, description);
    }

}