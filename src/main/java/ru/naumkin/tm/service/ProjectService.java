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
        return projectRepository.findOne(name);
    }

    public void persist(Project project) {
        projectRepository.persist(project);
    }

    public void merge(Project project, String name) {
        projectRepository.merge(project, name);
    }

    public void remove(Project project) {
        projectRepository.remove(project);
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

}
