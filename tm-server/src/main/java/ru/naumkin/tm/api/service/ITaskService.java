package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskService {

    @NotNull
    List<Task> findAll();

    @NotNull
    List<Task> findAll(@Nullable final String userId);

    @NotNull
    Task findOne(@Nullable final String userId, @Nullable final String name);

    void persist(@NotNull final Task task);

    void merge(@NotNull final Task task);

    void remove(@Nullable final String userId, @Nullable final Task task);

    void removeAll(@Nullable final String userId);

    @NotNull
    List<Task> sortByDateStart(@Nullable final String userId);

    @NotNull
    List<Task> sortByDateFinish(@Nullable final String userId);

    @NotNull
    List<Task> sortByStatus(@NotNull final String userId);

    @NotNull
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name);

    @NotNull
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description);

}
