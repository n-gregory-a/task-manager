package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.repository.ProjectRepository;

import java.util.Collection;

public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findOne(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        }
        Project project = projectRepository.findOne(name);
        if (project != null) {
            return project;
        } else {
            throw new NullPointerException("There is no project with name " + name);
        }
    }

    public void persist(Project project) {
        if (project != null) {
            projectRepository.persist(project);
        } else {
            throw new NullPointerException("There is no project to persist");
        }
    }

    public void merge(Project project, String name) {
        if (name.isEmpty() || project.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }

        Project updatingProject = projectRepository.findOne(name);
        if (updatingProject != null) {
            projectRepository.merge(project, name);
        } else {
            projectRepository.persist(project);
        }
    }

    public void remove(Project project) {
        if (project != null) {
            projectRepository.remove(project);
        } else {
            throw new NullPointerException("There is no project to remove.");
        }
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

}
