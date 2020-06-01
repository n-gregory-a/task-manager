package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @NotNull
    List<Task> findAll();

    @NotNull
    List<Task> findAllByUserId(@NotNull final String userId);

    @Nullable
    Task findOneByUserId(@NotNull final String userId,
                         @NotNull final String name);

    void persist(@NotNull final Task task);

    void merge(@NotNull final Task task);

    void remove(@NotNull final String userId,
                @NotNull final String id);

    void removeAll(@NotNull final String userId);

    @NotNull
    List<Task> sortByDateStart(@NotNull final String userId);

    @NotNull
    List<Task> sortByDateFinish(@NotNull final String userId);

    @NotNull
    List<Task> sortByStatus(@NotNull final String userId);

    @NotNull
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name);

    @NotNull
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description);

    @NotNull
    List<Task> findAllByProjectId(@NotNull final String userId, @NotNull final String projectId);

}
