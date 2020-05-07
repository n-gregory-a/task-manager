package ru.naumkin.tm.repository;

import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

import java.util.LinkedList;
import java.util.List;

public final class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

    private final ITaskRepository taskRepository;

    public ProjectRepository(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Project> findAll(final String currentUserId) {
        List<Project> result = new LinkedList<>();
        for (final Project project: map.values()) {
            boolean projectCreatedByCurrentUser =
                    currentUserId.equals(project.getUserId());
            if (projectCreatedByCurrentUser) {
                result.add(project);
            }
        }
        return result;
    }

    @Override
    public Project findOne(final String name, final String currentUserId) {
        Project result = null;
        for (final Project project: findAll(currentUserId)) {
            if (project.getName().equals(name)) {
                result = project;
            }
        }
        return result;
    }

    @Override
    public Project remove(final Project project) {
        List<String> nameList = new LinkedList<>();
        for (final Task t: taskRepository.findAll()) {
            final boolean taskAttachedToProject = t.getProjectId().equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (String name: nameList) {
            final Task task = taskRepository.findOne(name);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return project;
    }

    @Override
    public Project remove(final Project project, final String currentUserId) {
        final Project toRemove = findOne(project.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        List<String> nameList = new LinkedList<>();
        for (final Task t: taskRepository.findAll(currentUserId)) {
            final String projectId = t.getProjectId();
            if (projectId == null) {
                continue;
            }
            final boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (final String name: nameList) {
            final Task task = taskRepository.findOne(name, currentUserId);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return toRemove;
    }

    @Override
    public void removeAll(final String currentUserId) {
        List<Project> toRemove = findAll(currentUserId);
        for (final Project project: toRemove) {
            map.remove(project.getId());
        }
    }

}
