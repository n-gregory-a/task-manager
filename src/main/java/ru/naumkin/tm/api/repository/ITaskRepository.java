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

}
