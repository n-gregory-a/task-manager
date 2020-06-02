package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ISessionRepository;
import ru.naumkin.tm.entity.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@NoArgsConstructor
public final class SessionRepository extends AbstractRepository implements ISessionRepository {

    public SessionRepository(@NotNull final EntityManager entityManager) {
        super(entityManager);
    }

    @NotNull
    @Override
    public List<Session> findAll() {
        return entityManager.createQuery("SELECT FORM Session", Session.class).getResultList();
    }

    @Nullable
    @Override
    public Session findOne(@NotNull final String id) {
        @NotNull final TypedQuery<Session> query = entityManager.createQuery(
                "SELECT s FROM Session s WHERE s.id=:id",
                Session.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void persist(@NotNull final Session session) {
        entityManager.persist(session);
    }

    @Override
    public void merge(@NotNull final Session session) {
        entityManager.merge(session);
    }

    @Override
    public void remove(@NotNull final String id) {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Session s WHERE s.id=:id"
        );
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        @NotNull final Query query = entityManager.createQuery(
                "DELETE FROM Session"
        );
        query.executeUpdate();
    }

}
