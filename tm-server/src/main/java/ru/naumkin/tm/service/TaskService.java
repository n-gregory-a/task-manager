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
    public List<Task> findAll(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).findAll(currentUserId);
    }

    @NotNull
    @Override
    public Task findOne(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Task task =
                new TaskRepository(connection).findOne(currentUserId, name);
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
            @Nullable final String currentUserId,
            @Nullable final Task task
    ) throws SQLException {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Task toRemove =
                new TaskRepository(connection).remove(currentUserId, task);
        if (toRemove == null) {
            throw new TaskIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        new TaskRepository(connection).removeAll(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
            @Nullable final String currentUserId,
            @Nullable final String description
    ) throws SQLException {
        if (description == null) {
            throw new DescriptionIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (description.isEmpty()) {
            throw new DescriptionIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new TaskRepository(connection).sortByDescription(currentUserId, description);
    }

}