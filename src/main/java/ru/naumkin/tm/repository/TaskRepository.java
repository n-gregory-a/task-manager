package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import java.util.*;

public final class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public List<Task> findAll(@NotNull final String currentUserId) {
        @NotNull List<Task> result = new LinkedList<>();
        for (final Task task: map.values()) {
            final boolean taskCreatedByCurrentUser =
                    currentUserId.equals(task.getUserId());
            if (taskCreatedByCurrentUser) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public Task findOne(@NotNull final String name, @NotNull final String currentUserId) {
        @Nullable Task result = null;
        for (final Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    @Override
    public Task remove(@NotNull final Task task, @NotNull final String currentUserId) {
        @Nullable final Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getName());
        return toRemove;
    }

    @Override
    public void removeAll(@NotNull final String currentUserId) {
        @NotNull List<Task> toRemove = findAll(currentUserId);
        for (final Task task: toRemove) {
            map.remove(task.getName());
        }
    }

}
