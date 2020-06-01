package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;

@NoArgsConstructor
public class AbstractEndpoint {

    @NotNull
    protected ServiceLocator serviceLocator;

    public AbstractEndpoint(@NotNull final ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    protected void validate(@NotNull final String sessionToken) throws Exception {
        serviceLocator.getSessionService().validate(sessionToken);
    }

}
