package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    void persistProject(@NotNull final Session session,
                        @NotNull final Project project) throws Exception;

    @WebMethod
    void mergeProject(@NotNull final Session session,
                      @NotNull final Project project) throws Exception;

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@NotNull final Session session,
                                   @NotNull final String name) throws Exception;

    @WebMethod
    void removeProjectByUserId(@NotNull final Session session,
                               @NotNull final Project project) throws Exception;

    @WebMethod
    void removeAllProjectsByUserId(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@NotNull final Session session,
                                     @NotNull final String name) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@NotNull final Session session,
                                            @NotNull final String description) throws Exception;

}
