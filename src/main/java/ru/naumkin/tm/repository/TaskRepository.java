package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private static Map<String, Project> tasks = new HashMap<>();

    public Map<String, Project> findAll() {
        return tasks;
    }

    public Project findOne(String name) {
        return tasks.get(name);
    }

    public void remove(String name) {
        tasks.remove(name);
    }

    public void removeAll() {
        tasks.clear();
    }

}
