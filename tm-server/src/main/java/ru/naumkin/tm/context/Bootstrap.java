package ru.naumkin.tm.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.api.service.*;
import ru.naumkin.tm.enpoint.*;
import ru.naumkin.tm.service.*;

import javax.xml.ws.Endpoint;

@NoArgsConstructor
public final class Bootstrap implements ServiceLocator {

    @Getter
    @NotNull
    private final ServiceLocator serviceLocator = this;

    @Getter
    @NotNull
    private final IPropertyService propertyService = new PropertyService();

    @Getter
    @NotNull
    private final ITaskService taskService = new TaskService(propertyService);

    @Getter
    @NotNull
    private final IProjectService projectService = new ProjectService(propertyService);

    @Getter
    @NotNull
    private final IUserService userService = new UserService(propertyService);

    @Getter
    @NotNull
    private final IDomainService domainService = new DomainService(serviceLocator);

    @Getter
    @NotNull
    private final ISessionService sessionService = new SessionService(propertyService);

    @NotNull
    private final IProjectEndpoint projectEndpoint = new ProjectEndpoint(serviceLocator);

    @NotNull
    private final ITaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpoint(serviceLocator);

    @NotNull
    private final IDomainEndpoint domainEndpoint = new DomainEndpoint(serviceLocator);

    @NotNull
    private final ISessionEndpoint sessionEndpoint = new SessionEndpoint(sessionService);

    public void init() throws Exception {
        propertyService.init();
        registerEndpoint(projectEndpoint);
        registerEndpoint(taskEndpoint);
        registerEndpoint(userEndpoint);
        registerEndpoint(domainEndpoint);
        registerEndpoint(sessionEndpoint);
    }

    private void registerEndpoint(@Nullable final Object endpoint) {
        if (endpoint == null) {
            return;
        }
        @NotNull final String host = propertyService.getServerHost();
        @NotNull final Integer port = propertyService.getServerPort();
        @NotNull final String endpointName = endpoint.getClass().getSimpleName();
        @NotNull final String wsdl = "http://" + host +
                ":" + port + "/" + endpointName + "?WSDL";
        Endpoint.publish(wsdl, endpoint);
        System.out.println(wsdl);
    }

}
