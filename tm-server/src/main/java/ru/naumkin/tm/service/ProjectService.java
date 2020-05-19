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
            @Nullable final String currentUserId,
            @Nullable final String name
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
        @Nullable final Project project = projectRepository.findOne(currentUserId, name);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
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
            throw new ProjectIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @Nullable final Project toRemove = projectRepository.remove(currentUserId, project);
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

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
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
        return projectRepository.sortByName(currentUserId, name);
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @Nullable final String currentUserId,
            @Nullable final String description
    ) {
        if (description == null) {
            throw new DescriptionIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (description.isEmpty()) {
            throw new DescriptionIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.sortByDescription(currentUserId, description);
    }

}
