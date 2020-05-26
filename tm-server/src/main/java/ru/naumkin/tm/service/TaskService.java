package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;

import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class TaskService extends AbstractService<Task> implements ITaskService {

    public TaskService(@NotNull IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public @NotNull List<Task> findAll() throws Exception {
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.findAll();
    }

    @NotNull
    @Override
    public List<Task> findAll(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.findAll(userId);
    }

    @NotNull
    @Override
    public Task findOne(
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
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        @Nullable final Task task =
                taskRepository.findOneByUserId(userId, name);
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    @NotNull
    @Override
    public Task persist(@Nullable final Task task) throws Exception {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        @Nullable Task toPersist = null;
        try {
            toPersist = taskRepository.persist(task);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toPersist == null) {
            throw new TaskIsNullException();
        }
        return toPersist;
    }

    @NotNull
    @Override
    public Task merge(@Nullable final Task task) throws Exception {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        @Nullable Task toMerge = null;
        try {
            toMerge = taskRepository.merge(task);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toMerge == null) {
            throw new TaskIsNullException();
        }
        return toMerge;
    }

    @NotNull
    @Override
    public Task remove(
            @Nullable final String userId,
            @Nullable final Task task
    ) throws Exception {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        @Nullable Task toRemove = null;
        try {
            toRemove = taskRepository.remove(userId, task);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        if (toRemove == null) {
            throw new TaskIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        try {
            taskRepository.removeAll(userId);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.sortByDateStart(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.sortByDateFinish(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@Nullable final String userId) throws Exception {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession =getSqlSessionFactory().openSession();
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.sortByStatus(userId);
    }

    @NotNull
    @Override
    public List<Task> sortByName(
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
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.sortByName(userId, name);
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
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
        @NotNull final ITaskRepository taskRepository = sqlSession.getMapper(ITaskRepository.class);
        return taskRepository.sortByDescription(userId, description);
    }

}