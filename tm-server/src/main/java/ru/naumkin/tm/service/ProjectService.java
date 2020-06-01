package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.*;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
public final class ProjectService extends AbstractService<Project> implements IProjectService {

    @NotNull
    private IProjectRepository projectRepository;

    public ProjectService(
            @NotNull final  IPropertyService propertyService,
            @NotNull final IProjectRepository projectRepository
    ) {
        super(propertyService);
        this.projectRepository = projectRepository;
    }

    @Override
    public @NotNull List<Project> findAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects = projectRepository.findAll();
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public List<Project> findAllByUserId(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Project> projects = projectRepository.findAllByUserId(userId);
        entityManager.getTransaction().commit();
        return projects;
    }

    @NotNull
    @Override
    public Project findOneByUserId(
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
                projectRepository.findOneByUserId(userId, name);
        if (project == null) {
            throw new NoProjectWithSuchNameException(name);
        }
        entityManager.getTransaction().commit();
        return project;
    }

    @Override
    public void persist(@Nullable final Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        projectRepository.persist(project);
        entityManager.getTransaction().commit();
    }

    @Override
    public void merge(@Nullable final Project project) {
        if (project == null) {
            throw new ProjectIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        projectRepository.merge(project);
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
        projectRepository.remove(userId, project.getId());
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeAllByUserId(@Nullable final String userId) {
        if (userId == null) {
            throw new UserIdIsNullException();
        }
        if (userId.isEmpty()) {
            throw new UserIdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        projectRepository.removeAllByUserId(userId);
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
        @NotNull final List<Project> projects = projectRepository.sortByDateStart(userId);
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
        @NotNull final List<Project> projects = projectRepository.sortByDateFinish(userId);
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
        @NotNull final List<Project> projects = projectRepository.sortByStatus(userId);
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
        @NotNull final List<Project> projects = projectRepository.sortByName(userId, name);
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
        @NotNull final List<Project> projects = projectRepository.sortByDescription(userId, description);
        entityManager.getTransaction().commit();
        return projects;
    }

}