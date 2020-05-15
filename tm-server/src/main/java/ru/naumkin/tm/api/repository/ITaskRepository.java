package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository extends IRepository<Task> {

    @NotNull
    List<Task> findAll(@NotNull final String currentUserId);

    @Nullable
    Task findOne(@NotNull final String name, @NotNull final String currentUserId);

    @Nullable
    Task remove(@NotNull final Task task, @NotNull final String currentUserId);

    void removeAll(@NotNull final String currentUserId);

    @NotNull
    List<Task> sortByDateStart(@NotNull final String currentUserId);

    @NotNull
    List<Task> sortByDateFinish(@NotNull final String currentUserId);

    @NotNull
    List<Task> sortByStatus(@NotNull final String currentUserId);

    @NotNull
    List<Task> sortByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    List<Task> sortByDescription(@NotNull final String currentUserId, @NotNull final String description);

}
