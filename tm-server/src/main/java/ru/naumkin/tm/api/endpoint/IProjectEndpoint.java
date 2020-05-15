package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @NotNull
    @WebMethod
    List<Project> findAllProjects();

    @NotNull
    @WebMethod
    Project findOneProject(@Nullable final String name);

    @Nullable
    @WebMethod
    Project persistProject(@Nullable final Project project);

    @Nullable
    @WebMethod
    Project mergeProject(@Nullable final Project project, @Nullable final String name);

    @Nullable
    @WebMethod
    Project removeProject(@Nullable final Project project);

    @WebMethod
    void removeAllProjects();

    @WebMethod
    void loadProject(@NotNull final Project[] projects);

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@Nullable final String currentUserId, @Nullable final String name);

    @NotNull
    @WebMethod
    Project removeProjectByUserId(@NotNull final String currentUserId, @NotNull final Project project);

    @WebMethod
    void removeAllProjectsByUserId(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@NotNull final String currentUserId, @NotNull final String description);

}
