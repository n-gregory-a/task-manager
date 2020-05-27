package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.ISessionService;

@NoArgsConstructor
public class AbstractEndpoint {

    private ISessionService sessionService;

    public AbstractEndpoint(@NotNull final ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    protected void validate(@NotNull final String sessionToken) throws Exception {
        sessionService.validate(sessionToken);
    }

}
