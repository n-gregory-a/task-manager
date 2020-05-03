package ru.naumkin.tm.repository;

import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

import java.util.*;

public class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

    private final TaskRepository taskRepository;

    public ProjectRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Project merge(Project project, String id) {
        Project updatingProject = map.get(id);
        updatingProject.setName(project.getName());
        updatingProject.setDescription(project.getDescription());
        updatingProject.setDateStart(project.getDateStart());
        updatingProject.setDateFinish(project.getDateFinish());
        updatingProject.setUserId(project.getUserId());
        map.remove(id);
        return map.put(updatingProject.getId(), updatingProject);
    }

    @Override
    public List<Project> findAll(String currentUserId) {
        List<Project> result = new LinkedList<>();
        for (Project project: map.values()) {
            boolean projectCreatedByCurrentUser =
                    currentUserId.equals(project.getUserId());
            if (projectCreatedByCurrentUser) {
                result.add(project);
            }
        }
        return result;
    }

    @Override
    public Project findOne(String name, String currentUserId) {
        Project result = null;
        for (Project project: findAll(currentUserId)) {
            if (project.getName().equals(name)) {
                result = project;
            }
        }
        return result;
    }

    @Override
    public Project remove(Project project) {
        List<String> nameList = new LinkedList<>();
        for (Task t: taskRepository.findAll()) {
            boolean taskAttachedToProject = t.getProjectId().equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (String name: nameList) {
            Task task = taskRepository.findOne(name);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return project;
    }

    @Override
    public Project remove(Project project, String currentUserId) {
        Project toRemove = findOne(project.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        List<String> nameList = new LinkedList<>();
        for (Task t: taskRepository.findAll(currentUserId)) {
            boolean taskAttachedToProject = t.getProjectId().equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (String name: nameList) {
            Task task = taskRepository.findOne(name, currentUserId);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return toRemove;
    }

    @Override
    public void removeAll(String currentUserId) {
        List<Project> toRemove = findAll(currentUserId);
        for (Project project: toRemove) {
            map.remove(project.getId());
        }
    }

}
