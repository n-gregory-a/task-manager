package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TaskRepository extends AbstractRepository implements ITaskRepository {

    @NotNull
    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("FROM Task", Task.class).getResultList();
    }

    @NotNull
    @Override
    public List<Task> findAllByUserId(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId",
                Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Nullable
    @Override
    public Task findOneByUserId(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId AND Task.name=:name",
                Task.class);
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public void persist(@NotNull final Task task) {
        entityManager.persist(task);
    }

    @Override
    public void merge(@NotNull final Task task) {
        entityManager.merge(task);
    }

    @Override
    public void remove(@NotNull final String userId, @NotNull final String id) {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Task WHERE Task.user.id=:userId AND Task.id=:id");
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll(@NotNull final String userId) {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Task WHERE Task.user.id=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId ORDER BY Task.dateStart",
                Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId ORDER BY Task.dateFinish",
                Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId ORDER BY Task.status",
                Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByName(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE user.id=:userId AND Task.name LIKE %name%",
                Task.class);
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE user.id=:userId AND Task.description LIKE %description%",
                Task.class);
        query.setParameter("userId", userId);
        query.setParameter("description", description);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> findAllByProjectId(
            @NotNull final String userId,
            @NotNull final String projectId
    ) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "FROM Task WHERE Task.user.id=:userId AND Task.project.id=:projectId",
                Task.class);
        query.setParameter("userId", userId);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }

}
