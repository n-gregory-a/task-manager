package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@NoArgsConstructor
public final class UserRepository extends AbstractRepository implements IUserRepository {

    public UserRepository(@NotNull final EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public @NotNull List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public @Nullable User findOne(@NotNull final String name) {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.name=:name", User.class
        );
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public @Nullable User findOneById(@NotNull final String id) {
        @NotNull final TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id=:id",
                User.class
        );
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
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM User u WHERE u.id=:id"
        );
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM User u WHERE u.id=:id"
        );
        query.executeUpdate();
    }

}
