package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import java.util.LinkedList;
import java.util.List;

public final class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public @NotNull List<Task> findAll(final @NotNull String currentUserId) {
        List<Task> result = new LinkedList<>();
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
    public @Nullable Task findOne(final @NotNull String name, final @NotNull String currentUserId) {
        Task result = null;
        for (final Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    @Override
    public @Nullable Task remove(final @NotNull Task task, final @NotNull String currentUserId) {
        final @Nullable Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getName());
        return toRemove;
    }

    @Override
    public void removeAll(final @NotNull String currentUserId) {
        @Nullable List<Task> toRemove = findAll(currentUserId);
        for (final Task task: toRemove) {
            map.remove(task.getName());
        }
    }

}
