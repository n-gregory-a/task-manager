package ru.naumkin.tm.repository;

import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import java.util.*;

public class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public Task merge(Task task, String name) {
        Task updatingTask = map.get(name);
        updatingTask.setName(task.getName());
        updatingTask.setDescription(task.getDescription());
        updatingTask.setDateStart(task.getDateStart());
        updatingTask.setDateFinish(task.getDateFinish());
        updatingTask.setProjectId(task.getProjectId());
        updatingTask.setUserId(task.getUserId());
        map.remove(name);
        return map.put(updatingTask.getName(), updatingTask);
    }

    @Override
    public List<Task> findAll(String currentUserId) {
        List<Task> result = new LinkedList<>();
        for (Task task: map.values()) {
            boolean taskCreatedByCurrentUser =
                    currentUserId.equals(task.getUserId());
            if (taskCreatedByCurrentUser) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public Task findOne(String name, String currentUserId) {
        Task result = null;
        for (Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    @Override
    public Task remove(Task task, String currentUserId) {
        Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        map.remove(toRemove.getName());
        return toRemove;
    }

    @Override
    public void removeAll(String currentUserId) {
        List<Task> toRemove = findAll(currentUserId);
        for (Task task: toRemove) {
            map.remove(task.getName());
        }
    }

}
