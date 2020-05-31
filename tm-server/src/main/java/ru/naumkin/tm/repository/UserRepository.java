package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.entity.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository extends AbstractRepository implements IUserRepository {

    @Override
    public @NotNull List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public @Nullable User findOne(@NotNull final String name) {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "FROM USER WHERE User.name=:name",
                User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public @Nullable User findOneById(@NotNull final String id) {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "FROM USER WHERE User.id=:id",
                User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void persist(@NotNull final User user) {
        entityManager.persist(user);
    }

    @Override
    public void merge(@NotNull final User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(@NotNull final String id) {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "DELETE FROM USER WHERE User.id=:id",
                User.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "DELETE FROM USER WHERE User.id=:id",
                User.class);
        query.executeUpdate();
    }

}
