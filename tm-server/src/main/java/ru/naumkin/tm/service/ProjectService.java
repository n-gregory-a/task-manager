package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.ProjectRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    public ProjectService(
            @NotNull final  IPropertyService propertyService
    ) {
        super(propertyService);
    }

    @NotNull
    @Override
    public List<Project> findAll(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).findAll(currentUserId);
    }

    @NotNull
    @Override
    public Project findOne(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) throws SQLException {
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
        @NotNull final Connection connection = getConnection();
        @Nullable final Project project =
                new ProjectRepository(connection).findOne(currentUserId, name);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    @NotNull
    @Override
    public Project persist(@Nullable final Project project) throws SQLException {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).persist(project);
    }

    @NotNull
    @Override
    public Project merge(@Nullable final Project project) throws SQLException {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).merge(project);
    }

    @NotNull
    @Override
    public Project remove(
            @Nullable final String currentUserId,
            @Nullable final Project project
    ) throws SQLException {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Project toRemove =
                new ProjectRepository(connection).remove(currentUserId, project);
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final @Nullable String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        new ProjectRepository(connection).removeAll(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String currentUserId) throws SQLException {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    public List<Project> sortByName(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) throws SQLException {
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
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByName(currentUserId, name);
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @Nullable final String currentUserId,
            @Nullable final String description
    ) throws SQLException {
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
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDescription(currentUserId, description);
    }

}