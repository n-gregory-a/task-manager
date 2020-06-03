package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.TaskRepository;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
public final class TaskService extends AbstractService<Task> implements ITaskService {

    public TaskService(@NotNull final  IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public @NotNull List<Task> findAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks = new TaskRepository(entityManager).findAll();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public List<Task> findAll(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).findAllByUserId(userId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public Task findOne(
            @Nullable final String userId,
            @Nullable final String name
    ) {
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
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @Nullable final Task task =
                new TaskRepository(entityManager).findOneByUserId(userId, name);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    @Override
    public void persist(@Nullable final Task task) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new TaskRepository(entityManager).persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void merge(@Nullable final Task task) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new TaskRepository(entityManager).merge(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(
            @Nullable final String userId,
            @Nullable final Task task
    ) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new TaskRepository(entityManager).remove(userId, task.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeAll(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new TaskRepository(entityManager).removeAll(userId);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).sortByDateStart(userId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).sortByDateFinish(userId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).sortByStatus(userId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @Nullable final String userId,
            @Nullable final String name
    ) {
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
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).sortByName(userId, name);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @Override
    public @NotNull List<Task> sortByDescription(
            @Nullable final String userId,
            @Nullable final String description
    ) {
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
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).sortByDescription(userId, description);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @NotNull
    @Override
    public List<Task> findAllByProjectId(
            @Nullable final String userId,
            @Nullable final String ProjectId
    ) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        if (ProjectId == null) {
            throw new IdIsNullException();
        }
        if (ProjectId.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Task> tasks =
                new TaskRepository(entityManager).findAllByProjectId(userId, ProjectId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

}