package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IProjectEndpoint")
public final class ProjectEndpoint extends AbstractEndpoint implements IProjectEndpoint {

    @NotNull private IProjectService projectService;

    @NotNull private ISessionService sessionService;

    public ProjectEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final IProjectService projectService
    ) {
        super(sessionService);
        this.projectService = projectService;
        this.sessionService = sessionService;
    }

    @Override
    @WebMethod
    public void persistProject(@NotNull final String sessionToken,
                                  @NotNull final Project project) throws Exception {
        validate(sessionToken);
        projectService.persist(project);
    }

    @Override
    @WebMethod
    public void mergeProject(
            @NotNull final String sessionToken,
            @NotNull final Project project
    ) throws Exception {
        validate(sessionToken);
        projectService.merge(project);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjectsByUserId(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        return projectService.findAll(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProjectByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        return projectService.findOne(sessionService.getUserId(sessionToken), name);
    }

    @Override
    @WebMethod
    public void removeProjectByUserId(
            @NotNull final String sessionToken,
            @NotNull final Project project
    ) throws Exception {
        validate(sessionToken);
        projectService.remove(sessionService.getUserId(sessionToken), project);
    }

    @Override
    @WebMethod
    public void removeAllProjectsByUserId(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        projectService.removeAll(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateStart(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        return projectService.sortByDateStart(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateFinish(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        return projectService.sortByDateFinish(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByStatus(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        return projectService.sortByStatus(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByName(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        return projectService.sortByName(sessionService.getUserId(sessionToken), name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description
    ) throws Exception {
        validate(sessionToken);
        return projectService.sortByDescription(sessionService.getUserId(sessionToken), description);
    }

}
