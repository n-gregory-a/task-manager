package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.ProjectRepository;

import java.util.Collection;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<Project> findAll(String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.findAll(currentUserId);
    }

    public Project findOne(String name, String currentUserId) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        Project project = projectRepository.findOne(name, currentUserId);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    public Project findOne(String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        Project project = projectRepository.findOne(name);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    public void persist(Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        projectRepository.persist(project);
    }

    public void merge(Project project, String name) {
        if (name == null) {
            throw new NameIsEmptyException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (project.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        Project updatingProject = projectRepository.findOne(name);
        if (updatingProject == null) {
            projectRepository.persist(project);
        }
        projectRepository.merge(project);
    }

    public void remove(Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        projectRepository.remove(project);
    }

    public void remove(Project project, String currentUserId) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        Project toRemove = projectRepository.remove(project, currentUserId);
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

    public void removeAll(String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        projectRepository.removeAll(currentUserId);
    }
}
