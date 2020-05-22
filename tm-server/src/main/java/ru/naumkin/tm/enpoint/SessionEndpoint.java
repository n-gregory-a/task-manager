package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ISessionEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
    public List<Session> findAllSessions(@NotNull final Session session) throws Exception {
        validate(session);
        return sessionService.findAll();
    }

    @Nullable
    @Override
    @WebMethod
    public Session findOneSession(
            @NotNull final Session session,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        return sessionService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Session persistSession(@NotNull final Session session) throws Exception {
        validate(session);
        return sessionService.persist(session);
    }

    @Nullable
    @Override
    @WebMethod
    public Session mergeSession(@NotNull final Session session, @NotNull final String name) throws Exception {
        validate(session);
        return sessionService.merge(session);
    }

    @Nullable
    @Override
    @WebMethod
    public Session removeSession(@NotNull final Session session) throws Exception {
        validate(session);
        return sessionService.remove(session);
    }

    @Override
    @WebMethod
    public void removeAllSessions(@NotNull final Session session) throws Exception {
        validate(session);
        sessionService.removeAll();
    }

    @NotNull
    @Override
    @WebMethod
    public Session open(
            @NotNull final String login,
            @NotNull final String password
    ) throws Exception {
        return sessionService.open(login, password);
    }

    @Override
    @WebMethod
    public void close(@NotNull final Session session) throws Exception {
        sessionService.close(session);
    }

    @Override
    @WebMethod
    public void closeAll(@NotNull final Session session) throws Exception {
        sessionService.closeAll(session);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Session> getListSession(@NotNull final Session session) throws Exception {
        return sessionService.getListSession(session);
    }

    @Override
    @WebMethod
    public void validate(@NotNull final Session session) throws Exception {
        sessionService.validate(session);
    }

    @NotNull
    @Override
    @WebMethod
    public Session sign(@NotNull final Session session) {
        return sessionService.sign(session);
    }

}
