package ru.naumkin.tm.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.repository.IProjectRepository;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.*;
import ru.naumkin.tm.enpoint.DomainEndpoint;
import ru.naumkin.tm.enpoint.ProjectEndpoint;
import ru.naumkin.tm.enpoint.TaskEndpoint;
import ru.naumkin.tm.enpoint.UserEndpoint;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.repository.ProjectRepository;
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
    private final IDomainService domainService = new DomainService(projectService, taskService, userService);

    @Getter
    @NotNull
    private final IPropertyService propertyService = new PropertyService();

    @NotNull
    private final IProjectEndpoint projectEndpoint = new ProjectEndpoint(projectService);

    @NotNull
    private final ITaskEndpoint taskEndpoint = new TaskEndpoint(taskService);

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpoint(userService);

    @NotNull
    private final IDomainEndpoint domainEndpoint = new DomainEndpoint(domainService);

    public void init() throws Exception {
        propertyService.init();
        registerEndpoint(projectEndpoint);
        registerEndpoint(taskEndpoint);
        registerEndpoint(userEndpoint);
        registerEndpoint(domainEndpoint);
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
    }

}
