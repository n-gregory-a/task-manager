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

    public ProjectEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final IProjectService projectService
    ) {
        super(sessionService);
        this.projectService = projectService;
    }

    @Override
    @WebMethod
    public void persistProject(@NotNull final Session session,
                                  @NotNull final Project project) throws Exception {
        validate(session);
        projectService.persist(project);
    }

    @Override
    @WebMethod
    public void mergeProject(
            @NotNull final Session session,
            @NotNull final Project project,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        projectService.merge(project);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjectsByUserId(
            @NotNull final Session session
    ) throws Exception {
        validate(session);
        return projectService.findAll(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProjectByUserId(
            @NotNull final Session session,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        return projectService.findOne(session.getUserId(), name);
    }

    @Override
    @WebMethod
    public void removeProjectByUserId(
            @NotNull final Session session,
            @NotNull final Project project
    ) throws Exception {
        validate(session);
        projectService.remove(session.getUserId(), project);
    }

    @Override
    @WebMethod
    public void removeAllProjectsByUserId(
            @NotNull final Session session
    ) throws Exception {
        validate(session);
        projectService.removeAll(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateStart(
            @NotNull final Session session
    ) throws Exception {
        validate(session);
        return projectService.sortByDateStart(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateFinish(
            @NotNull final Session session
    ) throws Exception {
        validate(session);
        return projectService.sortByDateFinish(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByStatus(
            @NotNull final Session session
    ) throws Exception {
        validate(session);
        return projectService.sortByStatus(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByName(
            @NotNull final Session session,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        return projectService.sortByName(session.getUserId(), name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDescription(
            @NotNull final Session session,
            @NotNull final String description
    ) throws Exception {
        validate(session);
        return projectService.sortByDescription(session.getUserId(), description);
    }

}
