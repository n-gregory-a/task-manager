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
    public List<Session> findAllSessions(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        return sessionService.findAll();
    }

    @Nullable
    @Override
    @WebMethod
    public Session findOneSession(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        return sessionService.findOne(name);
    }

    @Override
    @WebMethod
    public void persistSession(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        sessionService.persist(sessionToken);
    }

    @Override
    @WebMethod
    public void mergeSession(@NotNull final String sessionToken, @NotNull final String name) throws Exception {
        validate(sessionToken);
        sessionService.merge(sessionToken);
    }

    @Override
    @WebMethod
    public void removeSession(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        sessionService.remove(sessionToken);
    }

    @Override
    @WebMethod
    public void removeAllSessions(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        sessionService.removeAll();
    }

    @NotNull
    @Override
    @WebMethod
    public String  open(
            @NotNull final String login,
            @NotNull final String password
    ) throws Exception {
        return sessionService.open(login, password);
    }

    @Override
    @WebMethod
    public void validate(@NotNull final String sessionToken) throws Exception {
        sessionService.validate(sessionToken);
    }

    @NotNull
    @Override
    @WebMethod
    public String getUserId(@NotNull final String sessionToken) throws Exception {
        return sessionService.getUserId(sessionToken);
    }

}
