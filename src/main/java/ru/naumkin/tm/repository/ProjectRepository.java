package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository {

    private Map<String, Project> projects = new HashMap<>();

    private TaskRepository taskRepository;

    public ProjectRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Project> findAll() {
        return (List<Project>) projects.values();
    }

    public Project findOne(String name) {
        return projects.get(name);
    }

    public void persist(Project project) {
        projects.put(project.getName(), project);
    }

    public void merge(Project project) {
        Project updatingProject = findOne(project.getName());
        updatingProject.setName(project.getName());
        updatingProject.setDescription(project.getDescription());
        updatingProject.setDateStart(project.getDateStart());
        updatingProject.setDateFinish(project.getDateFinish());
        projects.put(updatingProject.getName(), updatingProject);
    }

    public void remove(Project project) {
        projects.remove(project.getName());
    }

    public void removeAll() {
        projects.clear();
    }

}
