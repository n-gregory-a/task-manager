package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

import java.util.LinkedList;
import java.util.List;

public final class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

    private final ITaskRepository taskRepository;

    public ProjectRepository(final @NotNull ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public @NotNull List<Project> findAll(final @NotNull String currentUserId) {
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
    public @Nullable Project findOne(final @NotNull String name, final @NotNull String currentUserId) {
        Project result = null;
        for (final Project project: findAll(currentUserId)) {
            if (project.getName().equals(name)) {
                result = project;
            }
        }
        return result;
    }

    @Override
    public @NotNull Project remove(final @NotNull Project project) {
        List<String> nameList = new LinkedList<>();
        for (final @NotNull Task t: taskRepository.findAll()) {
            final boolean taskAttachedToProject = project.getId().equals(t.getProjectId());
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
    public @Nullable Project remove(final @NotNull Project project, final @NotNull String currentUserId) {
        final @Nullable Project toRemove = findOne(project.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        List<String> nameList = new LinkedList<>();
        for (final @NotNull Task t: taskRepository.findAll(currentUserId)) {
            final @Nullable String projectId = t.getProjectId();
            if (projectId == null) {
                continue;
            }
            final boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (final @NotNull String name: nameList) {
            final @Nullable Task task = taskRepository.findOne(name, currentUserId);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return toRemove;
    }

    @Override
    public void removeAll(final @NotNull String currentUserId) {
        @Nullable List<Project> toRemove = findAll(currentUserId);
        for (final Project project: toRemove) {
            map.remove(project.getId());
        }
    }

}
