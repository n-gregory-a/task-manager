package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.entity.Project;

import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    @NotNull
    private IProjectRepository projectRepository;

    public ProjectService(@NotNull final IProjectRepository repository) {
        super(repository);
        this.projectRepository = repository;
    }

    @NotNull
    @Override
    public List<Project> findAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.findAll(currentUserId);
    }

    @NotNull
    @Override
    public Project findOne(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        if (name == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (name.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        @Nullable final Project project = projectRepository.findOne(currentUserId, name);
        if (project == null) {
            throw new RuntimeException();
        }
        return project;
    }

    @NotNull
    @Override
    public Project remove(
            @Nullable final String currentUserId,
            @Nullable final Project project
    ) {
        if (project == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        @Nullable final Project toRemove = projectRepository.remove(currentUserId, project);
        if (toRemove == null) {
            throw new RuntimeException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final @Nullable String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        projectRepository.removeAll(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByName(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        if (name == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (name.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.sortByName(currentUserId, name);
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @Nullable final String currentUserId,
            @Nullable final String description
    ) {
        if (description == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (description.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return projectRepository.sortByDescription(currentUserId, description);
    }

}