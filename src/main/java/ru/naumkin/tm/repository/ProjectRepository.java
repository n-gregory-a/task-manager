package ru.naumkin.tm.repository;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

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

    public List<Project> findAll(String currentUserId) {
        List<Project> result = new LinkedList<>();
        for (Project project: projects.values()) {
            boolean projectCreatedByCurrentUser =
                    currentUserId.equals(project.getUserId());
            if (projectCreatedByCurrentUser) {
                result.add(project);
            }
        }
        return result;
    }

    public Project findOne(String name) {
        return projects.get(name);
    }

    public Project findOne(String name, String currentUserId) {
        Project result = new Project(name);
        for (Project project: findAll(currentUserId)) {
            if (project.getName().equals(name)) {
                result = project;
            }
        }
        return result;
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
        updatingProject.setUserId(project.getUserId());
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

    public void remove(Project project, String currentUserId) {
        List<String> nameList = new LinkedList<>();
        for (Task t: taskRepository.findAll(currentUserId)) {
            boolean taskAttachedToProject = t.getProjectId().equals(project.getID());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (String name: nameList) {
            Task task = taskRepository.findOne(name, currentUserId);
            taskRepository.remove(task);
        }
        projects.remove(project.getName());
    }

    public void removeAll() {
        projects.clear();
    }

}
