package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IProjectEndpoint")
public final class ProjectEndpoint implements IProjectEndpoint {

    @NotNull private IProjectService projectService;

    public ProjectEndpoint(@NotNull final IProjectService projectService) {
        this.projectService = projectService;
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjects() {
        return new LinkedList<>(projectService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProject(@Nullable final String name) {
        return projectService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Project persistProject(@Nullable final Project project) {
        return projectService.persist(project);
    }

    @Nullable
    @Override
    @WebMethod
    public Project mergeProject(
            @Nullable final Project project,
            @Nullable final String name
    ) {
        return projectService.merge(project, name);
    }

    @Nullable
    @Override
    @WebMethod
    public Project removeProject(@Nullable final Project project) {
        return projectService.remove(project);
    }

    @Override
    @WebMethod
    public void removeAllProjects() {
        projectService.removeAll();
    }

    @Override
    @WebMethod
    public void loadProject(@NotNull final Project[] projects) {
        projectService.persist(projects);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> findAllProjectsByUserId(@Nullable final String currentUserId) {
        return projectService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public Project findOneProjectByUserId(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        return projectService.findOne(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public Project removeProjectByUserId(
            @NotNull final String currentUserId,
            @NotNull final Project project
    ) {
        return projectService.remove(currentUserId, project);
    }

    @Override
    @WebMethod
    public void removeAllProjectsByUserId(@Nullable final String currentUserId) {
        projectService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateStart(@Nullable final String currentUserId) {
        return projectService.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDateFinish(@Nullable final String currentUserId) {
        return projectService.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByStatus(@NotNull final String currentUserId) {
        return projectService.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByName(
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        return projectService.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Project> sortProjectsByDescription(
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        return projectService.sortByDescription(currentUserId, description);
    }

}
