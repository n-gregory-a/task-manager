package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ISessionRepository;
import ru.naumkin.tm.entity.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public final class SessionRepository extends AbstractRepository implements ISessionRepository {

    @NotNull
    @Override
    public List<Session> findAll() {
        return entityManager.createQuery("FORM Session", Session.class).getResultList();
    }

    @Nullable
    @Override
    public Session findOne(@NotNull final String id) {
        @NotNull final TypedQuery<Session> query = entityManager.createQuery(
                "FROM Session WHERE Session.id=:id",
                Session.class);
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
        @NotNull final TypedQuery<Session> query = entityManager.createQuery(
                "DELETE FROM Session WHERE Session.id=:id",
                Session.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        @NotNull final TypedQuery<Session> query = entityManager.createQuery(
                "DELETE FROM Session",
                Session.class);
        query.executeUpdate();
    }

}
