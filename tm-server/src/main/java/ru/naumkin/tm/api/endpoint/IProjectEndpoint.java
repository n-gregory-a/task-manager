package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.ProjectDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @WebMethod
    void persistProject(@NotNull final String sessionToken,
                        @NotNull final ProjectDTO projectDTO) throws Exception;

    @WebMethod
    void mergeProject(@NotNull final String sessionToken,
                      @NotNull final ProjectDTO projectDTO) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> findAllProjectsByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    ProjectDTO findOneProjectByUserId(@NotNull final String sessionToken,
                                   @NotNull final String name) throws Exception;

    @WebMethod
    void removeProjectByUserId(@NotNull final String sessionToken,
                               @NotNull final ProjectDTO projectDTO) throws Exception;

    @WebMethod
    void removeAllProjectsByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> sortProjectsByDateStart(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> sortProjectsByDateFinish(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> sortProjectsByStatus(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> sortProjectsByName(@NotNull final String sessionToken,
                                     @NotNull final String name) throws Exception;

    @NotNull
    @WebMethod
    List<ProjectDTO> sortProjectsByDescription(@NotNull final String sessionToken,
                                            @NotNull final String description) throws Exception;

}
