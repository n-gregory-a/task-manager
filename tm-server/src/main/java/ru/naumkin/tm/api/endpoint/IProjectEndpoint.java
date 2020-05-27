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
    void persistProject(@NotNull final String sessionToken,
                        @NotNull final Project project) throws Exception;

    @WebMethod
    void mergeProject(@NotNull final String sessionToken,
                      @NotNull final Project project) throws Exception;

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@NotNull final String sessionToken,
                                   @NotNull final String name) throws Exception;

    @WebMethod
    void removeProjectByUserId(@NotNull final String sessionToken,
                               @NotNull final Project project) throws Exception;

    @WebMethod
    void removeAllProjectsByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@NotNull final String sessionToken,
                                     @NotNull final String name) throws Exception;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@NotNull final String sessionToken,
                                            @NotNull final String description) throws Exception;

}
