package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import java.util.LinkedList;
import java.util.List;

public final class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @NotNull
    @Override
    public List<Task> findAll(@NotNull final String currentUserId) {
        @NotNull final List<Task> result = new LinkedList<>();
        for (@NotNull final Task task: map.values()) {
            final boolean taskCreatedByCurrentUser =
                    currentUserId.equals(task.getUserId());
            if (taskCreatedByCurrentUser) {
                result.add(task);
            }
        }
        return result;
    }

    @Nullable
    @Override
    public Task findOne(
            @NotNull final String name,
            @NotNull final String currentUserId
    ) {
        Task result = null;
        for (@NotNull final Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    @Nullable
    @Override
    public Task remove(
            @NotNull final Task task,
            @NotNull final String currentUserId
    ) {
        @Nullable final Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getName());
        return toRemove;
    }

    @Override
    public void removeAll(final @NotNull String currentUserId) {
        @Nullable final List<Task> toRemove = findAll(currentUserId);
        for (@NotNull final Task task: toRemove) {
            map.remove(task.getName());
        }
    }

}
