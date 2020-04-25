package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private Map<String, Task> tasks = new HashMap<>();

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public Task findOne(String name) {
        return tasks.get(name);
    }

    public void persist(Task task) {
        tasks.put(task.getName(), task);
    }

    public void merge(Task task, String name) {
        Task updatingTask = findOne(name);
        updatingTask.setName(task.getName());
        updatingTask.setDescription(task.getDescription());
        updatingTask.setDateStart(task.getDateStart());
        updatingTask.setDateFinish(task.getDateFinish());
        updatingTask.setProjectId(task.getProjectId());
    }

    public void remove(Task task) {
        tasks.remove(task.getName());
    }

    public void removeAll() {
        tasks.clear();
    }

}
