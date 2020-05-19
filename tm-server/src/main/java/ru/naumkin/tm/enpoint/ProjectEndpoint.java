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
import java.util.LinkedList;
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

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjects(@Nullable final Session session) {
        validate(session);
        return new LinkedList<>(projectService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProject(@Nullable final Session session,
                                  @Nullable final String name) {
        validate(session);
        return projectService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Project persistProject(@Nullable final Session session,
                                  @Nullable final Project project) {
        validate(session);
        return projectService.persist(project);
    }

    @Nullable
    @Override
    @WebMethod
    public Project mergeProject(
            @Nullable final Session session,
            @Nullable final Project project,
            @Nullable final String name
    ) {
        validate(session);
        return projectService.merge(project, name);
    }

    @Nullable
    @Override
    @WebMethod
    public Project removeProject(@Nullable final Session session,
                                 @Nullable final Project project
    ) {
        validate(session);
        return projectService.remove(project);
    }

    @Override
    @WebMethod
    public void removeAllProjects(@Nullable final Session session) {
        validate(session);
        projectService.removeAll();
    }

    @Override
    @WebMethod
    public void loadProject(@Nullable final Session session,
                            @NotNull final Project[] projects) {
        validate(session);
        projectService.persist(projects);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjectsByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        validate(session);
        return projectService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProjectByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        validate(session);
        return projectService.findOne(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public Project removeProjectByUserId(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final Project project
    ) {
        validate(session);
        return projectService.remove(currentUserId, project);
    }

    @Override
    @WebMethod
    public void removeAllProjectsByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        validate(session);
        projectService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateStart(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        validate(session);
        return projectService.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateFinish(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        validate(session);
        return projectService.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByStatus(
            @Nullable final Session session,
            @NotNull final String currentUserId
    ) {
        validate(session);
        return projectService.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByName(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        validate(session);
        return projectService.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDescription(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        validate(session);
        return projectService.sortByDescription(currentUserId, description);
    }

}
