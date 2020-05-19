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
    List<Project> findAllProjects(@Nullable final Session session);

    @NotNull
    @WebMethod
    Project findOneProject(@Nullable final Session session,
                           @Nullable final String name);

    @Nullable
    @WebMethod
    Project persistProject(@Nullable final Session session,
                           @Nullable final Project project);

    @Nullable
    @WebMethod
    Project mergeProject(@Nullable final Session session,
                         @Nullable final Project project,
                         @Nullable final String name);

    @Nullable
    @WebMethod
    Project removeProject(@Nullable final Session session,
                          @Nullable final Project project);

    @WebMethod
    void removeAllProjects(@Nullable final Session session);

    @WebMethod
    void loadProject(@Nullable final Session session,
                     @NotNull final Project[] projects);

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@Nullable final Session session,
                                          @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@Nullable final Session session,
                                   @Nullable final String currentUserId,
                                   @Nullable final String name);

    @NotNull
    @WebMethod
    Project removeProjectByUserId(@Nullable final Session session,
                                  @NotNull final String currentUserId,
                                  @NotNull final Project project);

    @WebMethod
    void removeAllProjectsByUserId(@Nullable final Session session,
                                   @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@Nullable final Session session,
                                          @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@Nullable final Session session,
                                           @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@Nullable final Session session,
                                       @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@Nullable final Session session,
                                     @NotNull final String currentUserId,
                                     @NotNull final String name);

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@Nullable final Session session,
                                            @NotNull final String currentUserId,
                                            @NotNull final String description);

}
