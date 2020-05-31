package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.entity.Project;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectRepository extends AbstractRepository implements IProjectRepository {

    @NotNull
    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("FROM Project", Project.class).getResultList();
    }

    @Override
    public @NotNull List<Project> findAllByUserId(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query =
                entityManager.createQuery("FROM Project WHERE Project.user.id=:userId", Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public @Nullable Project findOne(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Project> query =
                entityManager.createQuery(
                        "FROM Project WHERE Project.user.id=:userId AND Project.name=:name",
                        Project.class);
        query.setParameter("userId", userId);
        query.setParameter("name", name);
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
        @NotNull final Query query = entityManager.createQuery(
                        "DELETE FROM Project WHERE Project.user.id=:userId AND Project.id=:id");
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll(@NotNull final String userId) {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Project WHERE Project.user.id=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public @NotNull List<Project> sortByDateStart(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "FROM Project WHERE Project.user.id=:userId ORDER BY Project.dateStart",
                Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public @NotNull List<Project> sortByDateFinish(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "FROM Project WHERE Project.user.id=:userId ORDER BY Project.dateFinish",
                Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public @NotNull List<Project> sortByStatus(@NotNull final String userId) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "FROM Project WHERE Project.user.id=:userId ORDER BY Project.status",
                Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public @NotNull List<Project> sortByName(@NotNull final String userId, @NotNull final String name) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "FROM Project WHERE user.id=:userId AND Project.name LIKE %name%",
                Project.class);
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public @NotNull List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description) {
        @NotNull final TypedQuery<Project> query = entityManager.createQuery(
                "FROM Project WHERE user.id=:userId AND Project.description LIKE %description%",
                Project.class);
        query.setParameter("userId", userId);
        query.setParameter("description", description);
        return query.getResultList();
    }

}
