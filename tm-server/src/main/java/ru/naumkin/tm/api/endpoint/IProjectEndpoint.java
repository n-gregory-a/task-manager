package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @NotNull
    @WebMethod
    List<Project> findAllProjects(@NotNull final Session session);

    @NotNull
    @WebMethod
    Project findOneProject(@NotNull final Session session,
                           @NotNull final String name);

    @Nullable
    @WebMethod
    Project persistProject(@NotNull final Session session,
                           @NotNull final Project project);

    @Nullable
    @WebMethod
    Project mergeProject(@NotNull final Session session,
                         @NotNull final Project project,
                         @NotNull final String name);

    @Nullable
    @WebMethod
    Project removeProject(@NotNull final Session session,
                          @NotNull final Project project);

    @WebMethod
    void removeAllProjects(@NotNull final Session session);

    @WebMethod
    void loadProject(@NotNull final Session session,
                     @NotNull final Project[] projects);

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@NotNull final Session session,
                                          @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@NotNull final Session session,
                                   @NotNull final String currentUserId,
                                   @NotNull final String name);

    @NotNull
    @WebMethod
    Project removeProjectByUserId(@NotNull final Session session,
                                  @NotNull final String currentUserId,
                                  @NotNull final Project project);

    @WebMethod
    void removeAllProjectsByUserId(@NotNull final Session session,
                                   @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@NotNull final Session session,
                                          @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@NotNull final Session session,
                                           @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@NotNull final Session session,
                                       @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@NotNull final Session session,
                                     @NotNull final String currentUserId,
                                     @NotNull final String name);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@NotNull final Session session,
                                            @NotNull final String currentUserId,
                                            @NotNull final String description);

}
