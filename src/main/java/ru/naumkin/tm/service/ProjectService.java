package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.repository.ProjectRepository;

import java.util.Collection;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findOne(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name is null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        }
        Project project = projectRepository.findOne(name);
        if (project == null) {
            throw new NullPointerException("There is no project with name " + name);
        }
        return project;
    }

    public void persist(Project project) {
        if (project == null) {
            throw new NullPointerException("There is no project to persist");
        }
        projectRepository.persist(project);
    }

    public void merge(Project project, String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name is null, updating failed");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }
        if (project == null) {
            throw new NullPointerException("There is no project to merge");
        }
        if (project.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }
        Project updatingProject = projectRepository.findOne(name);
        if (updatingProject != null) {
            projectRepository.merge(project, name);
        }
        if (updatingProject == null) {
            projectRepository.persist(project);
        }
    }

    public void remove(Project project) {
        if (project == null) {
            throw new NullPointerException("There is no project to remove");
        }
        projectRepository.remove(project);
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

}
