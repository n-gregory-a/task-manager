package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskService extends IService<Task> {

    @NotNull
    List<Task> findAll(@Nullable final String currentUserId);

    @Nullable
    Task findOne(@Nullable final String name, @Nullable final String currentUserId);

    @NotNull
    Task remove(@Nullable final Task task, @Nullable final String currentUserId);

    void removeAll(@Nullable final String currentUserId);

    @NotNull
    List<Task> sortByDateStart(@Nullable final String currentUserId);

    @NotNull
    List<Task> sortByDateFinish(@Nullable final String currentUserId);

}
