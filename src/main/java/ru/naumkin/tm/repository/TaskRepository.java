package ru.naumkin.tm.repository;

import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import java.util.LinkedList;
import java.util.List;

public final class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public List<Task> findAll(final String currentUserId) {
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
    public Task findOne(final String name, final String currentUserId) {
        Task result = null;
        for (final Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    @Override
    public Task remove(final Task task, final String currentUserId) {
        final Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getName());
        return toRemove;
    }

    @Override
    public void removeAll(final String currentUserId) {
        List<Task> toRemove = findAll(currentUserId);
        for (final Task task: toRemove) {
            map.remove(task.getName());
        }
    }

}
