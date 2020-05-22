package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskRepository {

    @NotNull
    List<Task> findAll() throws SQLException;

    @NotNull
    List<Task> findAll(@NotNull final String currentUserId) throws SQLException;

    @Nullable
    Task findOne(@NotNull final String currentUserId, @NotNull final String name) throws SQLException;

    @Nullable
    Task persist(@NotNull final Task task) throws SQLException;

    @Nullable
    Task merge(@NotNull final Task task) throws SQLException;

    @Nullable
    Task remove(@NotNull final String currentUserId, @NotNull final Task task) throws SQLException;

    void removeAll(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Task> sortByDateStart(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Task> sortByDateFinish(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Task> sortByStatus(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Task> sortByName(@NotNull final String currentUserId, @NotNull final String name) throws SQLException;

    @NotNull
    List<Task> sortByDescription(@NotNull final String currentUserId, @NotNull final String description) throws SQLException;

}
