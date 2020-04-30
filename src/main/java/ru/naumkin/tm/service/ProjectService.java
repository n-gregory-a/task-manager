package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;
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
            throw new NameIsEmptyException();
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
        projectRepository.merge(project, name);
    }

    public void remove(Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        projectRepository.remove(project);
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

}
