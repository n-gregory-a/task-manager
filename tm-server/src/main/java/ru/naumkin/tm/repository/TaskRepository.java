package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@NoArgsConstructor
public final class TaskRepository extends AbstractRepository implements ITaskRepository {

    public TaskRepository(@NotNull final EntityManager entityManager) {
        super(entityManager);
    }

    @NotNull
    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT FROM Task", Task.class).getResultList();
    }

    @NotNull
    @Override
    public List<Task> findAllByUserId(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId",
                Task.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Nullable
    @Override
    public Task findOneByUserId(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId AND t.name=:name",
                Task.class
        );
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
                "DELETE FROM Task t WHERE t.user.id=:userId AND t.id=:id");
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll(@NotNull final String userId) {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Task t WHERE t.user.id=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId ORDER BY t.dateStart",
                Task.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId ORDER BY t.dateFinish",
                Task.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@NotNull final String userId) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId ORDER BY t.status",
                Task.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByName(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId AND t.name LIKE %name%",
                Task.class
        );
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) {
        @NotNull final TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.user.id=:userId AND t.description LIKE %description%",
                Task.class
        );
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
                "SELECT t FROM Task t WHERE t.user.id=:userId AND t.project.id=:projectId",
                Task.class
        );
        query.setParameter("userId", userId);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }

}
