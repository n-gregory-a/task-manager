package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
public final class UserService extends AbstractService<User> implements IUserService {

    public UserService(@NotNull final IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public boolean isRoleAdmin(@Nullable final String id) {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final User user = findOneById(id);
        return user.getRole() == RoleType.ADMINISTRATOR;
    }

    @NotNull
    @Override
    public List<User> findAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<User> users = new UserRepository(entityManager).findAll();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @NotNull
    @Override
    public User findOne(@Nullable final String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @Nullable final User user = new UserRepository(entityManager).findOne(name);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (user == null) {
            throw new NoUserWithSuchLoginException(name);
        }
        return user;
    }

    @NotNull
    @Override
    public User findOneById(@Nullable final String id) {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @Nullable final User user = new UserRepository(entityManager).findOneById(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (user == null) {
            throw new NoUserWithSuchIdException(id);
        }
        return user;
    }

    @Override
    public void persist(@Nullable final User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new UserRepository(entityManager).persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void merge(@Nullable final User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new UserRepository(entityManager).merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(@Nullable final User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new UserRepository(entityManager).remove(user.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        new UserRepository(entityManager).removeAll();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
