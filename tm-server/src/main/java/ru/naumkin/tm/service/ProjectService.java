package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.ProjectRepository;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    public ProjectService(@NotNull final  IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public @NotNull List<Project> findAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects = new ProjectRepository(entityManager).findAll();
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public List<Project> findAll(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).findAllByUserId(userId);
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public Project findOne(
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
        @Nullable final Project project =
                new ProjectRepository(entityManager).findOneByUserId(userId, name);
        entityManager.getTransaction().commit();
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        return project;
    }

    @NotNull
    @Override
    public Project findOneById(
            @Nullable final String userId,
            @Nullable final String id
    ) {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @Nullable final Project project =
                new ProjectRepository(entityManager).findOneId(userId, id);
        entityManager.getTransaction().commit();
        if (project == null) {
            throw new NoProjectWithSuchNameException(id);
        }
        return project;
    }

    @Override
    public void persist(@Nullable final Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new ProjectRepository(entityManager).persist(project);
        entityManager.getTransaction().commit();
    }

    @Override
    public void merge(@Nullable final Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new ProjectRepository(entityManager).merge(project);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(
            @Nullable final String userId,
            @Nullable final Project project
    ) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new ProjectRepository(entityManager).remove(userId, project.getId());
        entityManager.getTransaction().commit();
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
        new ProjectRepository(entityManager).removeAllByUserId(userId);
        entityManager.getTransaction().commit();
    }

    @NotNull
    @Override
    public List<Project> sortByDateStart(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).sortByDateStart(userId);
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public List<Project> sortByDateFinish(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).sortByDateFinish(userId);
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public List<Project> sortByStatus(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).sortByStatus(userId);
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public List<Project> sortByName(
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
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).sortByName(userId, name);
        entityManager.getTransaction().commit();
        return projects;
    }

    @Override
    public @NotNull List<Project> sortByDescription(
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
        @NotNull final List<Project> projects =
                new ProjectRepository(entityManager).sortByDescription(userId, description);
        entityManager.getTransaction().commit();
        return projects;
    }

}