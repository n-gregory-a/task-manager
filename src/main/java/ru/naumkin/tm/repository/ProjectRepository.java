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

    public ProjectRepository(@NotNull final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @NotNull
    @Override
    public List<Project> findAll(@NotNull final String currentUserId) {
        @NotNull final List<Project> result = new LinkedList<>();
        for (@NotNull final Project project: map.values()) {
            boolean projectCreatedByCurrentUser =
                    currentUserId.equals(project.getUserId());
            if (projectCreatedByCurrentUser) {
                result.add(project);
            }
        }
        return result;
    }

    @Nullable
    @Override
    public Project findOne(
            @NotNull final String name,
            @NotNull final String currentUserId
    ) {
        Project result = null;
        for (@NotNull final Project project: findAll(currentUserId)) {
            if (project.getName().equals(name)) {
                result = project;
            }
        }
        return result;
    }

    @NotNull
    @Override
    public Project remove(@NotNull final Project project) {
        @NotNull final List<String> nameList = new LinkedList<>();
        for (@NotNull final Task t: taskRepository.findAll()) {
            final boolean taskAttachedToProject = project.getId().equals(t.getProjectId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (@NotNull final String name: nameList) {
            @NotNull final Task task = taskRepository.findOne(name);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return project;
    }

    @Nullable
    @Override
    public Project remove(
            @NotNull final Project project,
            @NotNull final String currentUserId
    ) {
        @Nullable final Project toRemove = findOne(project.getName(), currentUserId);
        if (toRemove == null) {
            return null;
        }
        List<String> nameList = new LinkedList<>();
        for (@NotNull final Task t: taskRepository.findAll(currentUserId)) {
            @Nullable final String projectId = t.getProjectId();
            if (projectId == null) {
                continue;
            }
            final boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                nameList.add(t.getName());
            }
        }
        for (@NotNull final String name: nameList) {
            @Nullable final Task task = taskRepository.findOne(name, currentUserId);
            taskRepository.remove(task);
        }
        map.remove(project.getId());
        return toRemove;
    }

    @Override
    public void removeAll(@NotNull final String currentUserId) {
        @Nullable final List<Project> toRemove = findAll(currentUserId);
        for (@NotNull final Project project: toRemove) {
            map.remove(project.getId());
        }
    }

}
