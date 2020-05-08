package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;

import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectService(@NotNull final IProjectRepository repository) {
        super(repository);
        this.projectRepository = repository;
    }

    @NotNull
    @Override
    public List<Project> findAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.findAll(currentUserId);
    }

    @NotNull
    @Override
    public Project findOne(
            @Nullable final String name,
            @Nullable final String currentUserId
    ) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @Nullable final Project project = projectRepository.findOne(name, currentUserId);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    @NotNull
    @Override
    public Project remove(
            @Nullable final Project project,
            @Nullable final String currentUserId
    ) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @Nullable final Project toRemove = projectRepository.remove(project, currentUserId);
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final @Nullable String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        projectRepository.removeAll(currentUserId);
    }

}
