package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectRepository extends AbstractRepository implements IProjectRepository {

    public ProjectRepository(@NotNull final EntityManager entityManager) {
        super(entityManager);
    }

    @NotNull
    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("SELECT FROM Project", Project.class).getResultList();
    }

    @NotNull
    @Override
    public List<Project> findAllByUserId(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId",
                Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Nullable
    @Override
    public Project findOneByUserId(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                        "SELECT p FROM Project p WHERE p.user.id=:userId AND p.name=:name",
                        Project.class);
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Nullable
    @Override
    public Project findOneId(@NotNull final String userId, @NotNull final String id) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId AND p.id=:id",
                Project.class);
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void persist(@NotNull final Project project) {
        entityManager.persist(project);
    }

    @Override
    public void merge(@NotNull final Project project) {
        entityManager.merge(project);
    }

    @Override
    public void remove(@NotNull final String userId, @NotNull final String id) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                        "DELETE FROM Project p WHERE p.user.id=:userId AND p.id=:id",
                        Project.class
        );
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAllByUserId(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "DELETE FROM Project p WHERE p.user.id=:userId",
                Project.class
        );
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId ORDER BY p.dateStart",
                Project.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId ORDER BY p.dateFinish",
                Project.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId ORDER BY p.status",
                Project.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Project> sortByName(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId AND p.name LIKE %name%",
                Project.class
        );
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @NotNull
    @Override
    public List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "SELECT p FROM Project p WHERE p.user.id=:userId AND p.description LIKE %description%",
                Project.class
        );
        query.setParameter("userId", userId);
        query.setParameter("description", description);
        return query.getResultList();
    }

}
