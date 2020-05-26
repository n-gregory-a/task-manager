package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    @NotNull
    List<Task> findAll() throws Exception;

    @NotNull
    List<Task> findAll(@Nullable final String userId) throws Exception;

    @NotNull
    Task findOne(@Nullable final String userId, @Nullable final String name) throws Exception;

    void persist(@NotNull final Task task) throws Exception;

    void merge(@NotNull final Task task) throws Exception;

    void remove(@Nullable final String userId, @Nullable final Task task) throws Exception;

    void removeAll(@Nullable final String userId) throws Exception;

    @NotNull
    List<Task> sortByDateStart(@Nullable final String userId) throws Exception;

    @NotNull
    List<Task> sortByDateFinish(@Nullable final String userId) throws Exception;

    @NotNull
    List<Task> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
