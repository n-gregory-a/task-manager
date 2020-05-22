package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskService {

    @NotNull
    List<Task> findAll() throws SQLException;

    @NotNull
    List<Task> findAll(@Nullable final String userId) throws SQLException;

    @NotNull
    Task findOne(@Nullable final String userId, @Nullable final String name) throws SQLException;

    @Nullable
    Task persist(@NotNull final Task task) throws SQLException;

    @Nullable
    Task merge(@NotNull final Task task) throws SQLException;

    @NotNull
    Task remove(@Nullable final String userId, @Nullable final Task task) throws SQLException;

    void removeAll(@Nullable final String userId) throws SQLException;

    @NotNull
    List<Task> sortByDateStart(@Nullable final String userId) throws SQLException;

    @NotNull
    List<Task> sortByDateFinish(@Nullable final String userId) throws SQLException;

    @NotNull
    List<Task> sortByStatus(@NotNull final String userId) throws SQLException;

    @NotNull
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name) throws SQLException;

    @NotNull
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) throws SQLException;

}
