package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {

    private static Map<String, Project> projects = new HashMap<>();

    public Map<String, Project> findAll() {
        return projects;
    }

    public Project findOne(String name) {
        return projects.get(name);
    }

    public void persist(Project project) {
        projects.put(project.getName(), project);
    }

    public void remove(String name) {
        projects.remove(name);
    }

    public void removeAll() {
        projects.clear();
    }

}
