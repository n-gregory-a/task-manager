package ru.naumkin.tm.service;

import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;

import java.util.List;

public final class ProjectService extends AbstractService<Project> implements IProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(final IProjectRepository repository) {
        super(repository);
        this.projectRepository = repository;
    }

    @Override
    public List<Project> findAll(final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return projectRepository.findAll(currentUserId);
    }

    @Override
    public Project findOne(final String name, final String currentUserId) {
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
        final Project project = projectRepository.findOne(name, currentUserId);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    @Override
    public Project remove(final Project project, final String currentUserId) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        final Project toRemove = projectRepository.remove(project, currentUserId);
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        projectRepository.removeAll(currentUserId);
    }

}
