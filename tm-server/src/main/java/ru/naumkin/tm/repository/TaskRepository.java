package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.comparator.TaskDateFinishComparator;
import ru.naumkin.tm.comparator.TaskDateStartComparator;
import ru.naumkin.tm.comparator.TaskStatusComparator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
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
            @NotNull final String currentUserId,
            @NotNull final String name
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
            @NotNull final String currentUserId,
            @NotNull final Task task
    ) {
        @Nullable final Task toRemove = findOne(currentUserId, task.getName());
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getId());
        return toRemove;
    }

    @Override
    public void removeAll(final @NotNull String currentUserId) {
        @Nullable final List<Task> toRemove = findAll(currentUserId);
        for (@NotNull final Task task: toRemove) {
            map.remove(task.getName());
        }
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@NotNull final String currentUserId) {
        @NotNull List<Task> result = findAll(currentUserId);
        @NotNull Comparator<Task> dateStartComparator = new TaskDateStartComparator();
        result.sort(dateStartComparator);
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@NotNull final String currentUserId) {
        @NotNull final List<Task> result = findAll(currentUserId);
        @NotNull final Comparator<Task> dateFinishComparator = new TaskDateFinishComparator();
        result.sort(dateFinishComparator);
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@NotNull final String currentUserId) {
        @NotNull final List<Task> result = findAll(currentUserId);
        @NotNull final Comparator<Task> statusComparator = new TaskStatusComparator();
        result.sort(statusComparator);
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        @NotNull final List<Task> all = findAll(currentUserId);
        @NotNull final List<Task> result = new LinkedList<>();
        for (@NotNull final Task task: all) {
            if (task.getName().contains(name)) {
                result.add(task);
            }
        }
        return result;
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        @NotNull final List<Task> all = findAll(currentUserId);
        @NotNull final List<Task> result = new LinkedList<>();
        for (@NotNull final Task task: all) {
            if (task.getDescription().contains(description)) {
                result.add(task);
            }
        }
        return result;
    }

}
