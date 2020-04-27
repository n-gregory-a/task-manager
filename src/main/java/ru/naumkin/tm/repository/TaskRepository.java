package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Task;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskRepository {

    private final Map<String, Task> tasks = new LinkedHashMap<>();

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
        Task updatingTask = tasks.get(name);
        updatingTask.setName(task.getName());
        updatingTask.setDescription(task.getDescription());
        updatingTask.setDateStart(task.getDateStart());
        updatingTask.setDateFinish(task.getDateFinish());
        updatingTask.setProjectId(task.getProjectId());
        tasks.remove(name);
        tasks.put(updatingTask.getName(), updatingTask);
    }

    public void remove(Task task) {
        tasks.remove(task.getName());
    }

    public void removeAll() {
        tasks.clear();
    }

}
