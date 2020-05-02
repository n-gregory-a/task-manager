package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Task;

import java.util.*;

public class TaskRepository {

    private final Map<String, Task> tasks = new LinkedHashMap<>();

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public List<Task> findAll(String currentUserId) {
        List<Task> result = new LinkedList<>();
        for (Task task: tasks.values()) {
            boolean taskCreatedByCurrentUser =
                    currentUserId.equals(task.getUserId());
            if (taskCreatedByCurrentUser) {
                result.add(task);
            }
        }
        return result;
    }

    public Task findOne(String name) {
        return tasks.get(name);
    }

    public Task findOne(String name, String currentUserId) {
        Task result = null;
        for (Task task: findAll(currentUserId)) {
            if (task.getName().equals(name)) {
                result = task;
            }
        }
        return result;
    }

    public void persist(Task task) {
        tasks.put(task.getID(), task);
    }

    public void merge(Task task, String name) {
        Task updatingTask = tasks.get(name);
        updatingTask.setName(task.getName());
        updatingTask.setDescription(task.getDescription());
        updatingTask.setDateStart(task.getDateStart());
        updatingTask.setDateFinish(task.getDateFinish());
        updatingTask.setProjectId(task.getProjectId());
        updatingTask.setUserId(task.getUserId());
        tasks.remove(name);
        tasks.put(updatingTask.getName(), updatingTask);
    }

    public void remove(Task task) {
        tasks.remove(task.getName());
    }

    public Task remove(Task task, String currentUserId) {
        Task toRemove = findOne(task.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        tasks.remove(toRemove.getName());
        return toRemove;
    }

    public void removeAll() {
        tasks.clear();
    }

    public void removeAll(String currentUserId) {
        List<Task> toRemove = findAll(currentUserId);
        for (Task task: toRemove) {
            tasks.remove(task.getName());
        }
    }

}
