package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;

import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    public ProjectService(
            @NotNull final  IPropertyService propertyService
    ) {
        super(propertyService);
    }

    @Override
    public @NotNull List<Project> findAll() throws Exception {
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.findAll();
    }

    @NotNull
    @Override
    public List<Project> findAll(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.findAllByUserId(userId);
    }

    @NotNull
    @Override
    public Project findOne(
            @Nullable final String userId,
            @Nullable final String name
    ) throws Exception {
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
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        @Nullable final Project project =
                projectRepository.findOne(userId, name);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    @NotNull
    @Override
    public Project persist(@Nullable final Project project) throws Exception {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        @Nullable Project toPersist = null;
        try {
            toPersist = projectRepository.persist(project);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toPersist == null) {
            throw new ProjectIsNullException();
        }
        return toPersist;
    }

    @NotNull
    @Override
    public Project merge(@Nullable final Project project) throws Exception {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        @Nullable Project toMerge = null;
        try {
            toMerge = projectRepository.merge(project);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toMerge == null) {
            throw new ProjectIsNullException();
        }
        return toMerge;
    }

    @NotNull
    @Override
    public Project remove(
            @Nullable final String userId,
            @Nullable final Project project
    ) throws Exception {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        @Nullable Project toRemove = null;
        try {
            toRemove = projectRepository.remove(userId, project);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toRemove == null) {
            throw new ProjectIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final @Nullable String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        try {
            projectRepository.removeAll(userId);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.sortByDateStart(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.sortByDateFinish(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.sortByStatus(userId);
    }

    @NotNull
    @Override
    public List<Project> sortByName(
            @Nullable final String userId,
            @Nullable final String name
    ) throws Exception {
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
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.sortByName(userId, name);
    }

    @Override
    public @NotNull List<Project> sortByDescription(
            @Nullable final String userId,
            @Nullable final String description
    ) throws Exception {
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
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final IProjectRepository projectRepository =
                sqlSession.getMapper(IProjectRepository.class);
        return projectRepository.sortByDescription(userId, description);
    }

}