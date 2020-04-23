package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private static Map<String, Task> tasks = new HashMap<>();

    public Map<String, Task> findAll() {
        return tasks;
    }

    public Task findOne(String name) {
        return tasks.get(name);
    }

    public void persist(Task task) {
        tasks.put(task.getName(), task);
    }

    public void remove(String name) {
        tasks.remove(name);
    }

    public void removeAll() {
        tasks.clear();
    }

}
