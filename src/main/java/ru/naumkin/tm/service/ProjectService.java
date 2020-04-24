package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.util.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findOne(String name) {
        return projectRepository.findOne(name);
    }

    public void persist(Project project) {
        projectRepository.persist(project);
    }

    public void merge(Project project) {
        projectRepository.merge(project);
    }

    public void remove(String name) {
        projectRepository.remove(name);
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

}
