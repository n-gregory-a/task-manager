package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ISessionEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.enumerated.RoleType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.ISessionEndpoint")
public class SessionEndpoint implements ISessionEndpoint {

    private ISessionService sessionService;

    public SessionEndpoint(@NotNull final ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    @NotNull
    @Override
    @WebMethod
    public List<Session> findAllSessions(@NotNull final Session session) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        return new LinkedList<>(sessionService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public Session findOneSession(
            @NotNull final Session session,
            @NotNull final String name
    ) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        return sessionService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Session persistSession(@NotNull final Session session) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        return sessionService.persist(session);
    }

    @Nullable
    @Override
    @WebMethod
    public Session mergeSession(@NotNull final Session session, @NotNull final String name) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        return sessionService.merge(session, name);
    }

    @Nullable
    @Override
    @WebMethod
    public Session removeSession(@NotNull final Session session) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        return sessionService.remove(session);
    }

    @Override
    @WebMethod
    public void removeAllSessions(@NotNull final Session session) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        sessionService.removeAll();
    }

    @Override
    @WebMethod
    public void persistSessions(
            @NotNull final Session session,
            @NotNull final Session[] sessions
    ) {
        RoleType role = sessionService.getUser(session).getRole();
        validateAdmin(session, role);
        sessionService.persist(sessions);
    }

    @NotNull
    @Override
    @WebMethod
    public Session open(
            @NotNull final String login,
            @NotNull final String password
    ) {
        return sessionService.open(login, password);
    }

    @Override
    @WebMethod
    public void close(@NotNull final Session session) {
        sessionService.close(session);
    }

    @Override
    @WebMethod
    public void closeAll(@NotNull final Session session) {
        sessionService.closeAll(session);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Session> getListSession(@NotNull final Session session) {
        return sessionService.getListSession(session);
    }

    @Override
    @WebMethod
    public void validate(@NotNull final Session session) {
        sessionService.validate(session);
    }

    @Override
    public void validateAdmin(@NotNull final Session session, @NotNull final RoleType role) {
        sessionService.validate(session, role);
    }

    @NotNull
    @Override
    @WebMethod
    public Session sign(@NotNull final Session session) {
        return sessionService.sign(session);
    }

    @Override
    @WebMethod
    public boolean isValid(@NotNull final Session session) {
        return sessionService.isValid(session);
    }

}
