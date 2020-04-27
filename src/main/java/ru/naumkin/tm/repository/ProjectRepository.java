package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

import java.util.*;

public class ProjectRepository {

    private final Map<String, Project> projects = new LinkedHashMap<>();

    private final TaskRepository taskRepository;

    public ProjectRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Collection<Project> findAll() {
        return projects.values();
    }

    public Project findOne(String name) {
        return projects.get(name);
    }

    public void persist(Project project) {
        projects.put(project.getName(), project);
    }

    public void merge(Project project, String name) {
        Project updatingProject = projects.get(name);
        updatingProject.setName(project.getName());
        updatingProject.setDescription(project.getDescription());
        updatingProject.setDateStart(project.getDateStart());
        updatingProject.setDateFinish(project.getDateFinish());
        projects.remove(name);
        projects.put(updatingProject.getName(), updatingProject);
    }

    public void remove(Project project) {
        List<String> nameList = new LinkedList<>();
        for (Task t: taskRepository.findAll()) {
            boolean taskAttachedToProject = t.getProjectId().equals(project.getID());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (String name: nameList) {
            Task task = taskRepository.findOne(name);
            taskRepository.remove(task);
        }
        projects.remove(project.getName());
    }

    public void removeAll() {
        projects.clear();
    }

}
