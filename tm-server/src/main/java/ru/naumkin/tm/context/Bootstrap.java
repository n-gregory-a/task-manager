package ru.naumkin.tm.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.*;
import ru.naumkin.tm.enpoint.*;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.SessionRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.service.*;

import javax.xml.ws.Endpoint;

@NoArgsConstructor
public final class Bootstrap implements ServiceLocator {

    @NotNull
    private final ITaskRepository taskRepository = new TaskRepository();

    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepository(taskRepository);

    @NotNull
    private final IRepository<User> userRepository = new UserRepository();

    @NotNull
    private final IRepository<Session> sessionIRepository = new SessionRepository();

    @Getter
    @NotNull
    private final ITaskService taskService = new TaskService(taskRepository);

    @Getter
    @NotNull
    private final IProjectService projectService = new ProjectService(projectRepository);

    @Getter
    @NotNull
    private final IUserService userService = new UserService(userRepository);

    @Getter
    @NotNull
    private final IDomainService domainService =
            new DomainService(projectService, taskService, userService);

    @Getter
    @NotNull
    private final IPropertyService propertyService = new PropertyService();

    @Getter
    @NotNull
    private final ISessionService sessionService = new SessionService(
            sessionIRepository, projectService, taskService, userService, propertyService);

    @NotNull
    private final IProjectEndpoint projectEndpoint =
            new ProjectEndpoint(sessionService, projectService);

    @NotNull
    private final ITaskEndpoint taskEndpoint =
            new TaskEndpoint(sessionService, taskService);

    @NotNull
    private final IUserEndpoint userEndpoint =
            new UserEndpoint(sessionService, userService);

    @NotNull
    private final IDomainEndpoint domainEndpoint =
            new DomainEndpoint(sessionService, domainService);

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
