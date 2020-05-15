package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskService extends IService<Task> {

    @NotNull
    List<Task> findAll(@Nullable final String currentUserId);

    @NotNull
    Task findOne(@Nullable final String currentUserId, @Nullable final String name);

    @NotNull
    Task remove(@Nullable final String currentUserId, @Nullable final Task task);

    void removeAll(@Nullable final String currentUserId);

    @NotNull
    List<Task> sortByDateStart(@Nullable final String currentUserId);

    @NotNull
    List<Task> sortByDateFinish(@Nullable final String currentUserId);

    @NotNull
    List<Task> sortByStatus(@NotNull final String currentUserId);

    @NotNull
    List<Task> sortByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    List<Task> sortByDescription(@NotNull final String currentUserId, @NotNull final String description);

}