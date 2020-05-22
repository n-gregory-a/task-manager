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
    public List<Project> findAll(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).findAll(userId);
    }

    @NotNull
    @Override
    public Project findOne(
            @Nullable final String userId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Project project =
                new ProjectRepository(connection).findOne(userId, name);
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
            @Nullable final String userId,
            @Nullable final Project project
    ) throws SQLException {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        @Nullable final Project toRemove =
                new ProjectRepository(connection).remove(userId, project);
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final @Nullable String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        new ProjectRepository(connection).removeAll(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDateStart(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDateFinish(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String userId) throws SQLException {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByStatus(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByName(
            @Nullable final String userId,
            @Nullable final String name
    ) throws SQLException {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByName(userId, name);
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @Nullable final String userId,
            @Nullable final String description
    ) throws SQLException {
        if (description == null) {
            throw new DescriptionIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (description.isEmpty()) {
            throw new DescriptionIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final Connection connection = getConnection();
        return new ProjectRepository(connection).sortByDescription(userId, description);
    }

}