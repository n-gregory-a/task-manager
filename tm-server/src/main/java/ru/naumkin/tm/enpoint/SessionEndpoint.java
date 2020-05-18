package ru.naumkin.tm.enpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ISessionEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.entity.Session;

import java.util.LinkedList;
import java.util.List;

public class SessionEndpoint implements ISessionEndpoint {

    @NotNull
    private ISessionService sessionService;

    public SessionEndpoint(@NotNull final ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    @NotNull
    @Override
    public List<Session> findAllSessions() {
        return new LinkedList<>(sessionService.findAll());
    }

    @NotNull
    @Override
    public Session findOneSession(@Nullable final String name) {
        return sessionService.findOne(name);
    }

    @Nullable
    @Override
    public Session persistSession(@Nullable final Session session) {
        return sessionService.persist(session);
    }

    @Nullable
    @Override
    public Session mergeSession(@Nullable final Session session, @Nullable final String name) {
        return sessionService.merge(session, name);
    }

    @Nullable
    @Override
    public Session removeSession(@Nullable final Session session) {
        return sessionService.remove(session);
    }

    @Override
    public void removeAllSessions() {
        sessionService.removeAll();
    }

    @Override
    public void persistSession(@NotNull final Session[] sessions) {
        sessionService.persist(sessions);
    }

    @Override
    public void open(@NotNull final String login, @NotNull final String password) {
        sessionService.open(login, password);
    }

    @Override
    public void close(@NotNull final Session session) {
        sessionService.close(session);
    }

    @Override
    public void closeAll(@NotNull final Session session) {
        sessionService.closeAll(session);
    }

    @Override
    public @NotNull List<Session> getListSession(@NotNull final Session session) {
        return sessionService.getListSession(session);
    }

    @Override
    public void validate(@NotNull final Session session) {
        sessionService.validate(session);
    }

    @NotNull
    @Override
    public Session sign(@NotNull final Session session) {
        return sessionService.sign(session);
    }

    @Override
    public boolean isValid(@NotNull final Session session) {
        return sessionService.isValid(session);
    }

}
