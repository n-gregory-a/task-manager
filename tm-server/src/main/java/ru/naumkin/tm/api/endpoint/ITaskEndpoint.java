package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.TaskDTO;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @WebMethod
    void persistTask(@NotNull final String sessionToken, @NotNull final TaskDTO taskDTO) throws Exception;

    @WebMethod
    void mergeTask(
            @NotNull final String sessionToken,
            @NotNull final TaskDTO taskDTO) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> findAllTasksByUserId(
            @NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    TaskDTO findOneTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name) throws Exception;

    @WebMethod
    void removeTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final TaskDTO taskDTO) throws Exception;

    @WebMethod
    void removeAllTasksByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> sortTasksByDateStart(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> sortTasksByDateFinish(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> sortTasksByStatus(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> sortTasksByName(
            @NotNull final String sessionToken,
            @NotNull final String name) throws Exception;

    @NotNull
    @WebMethod
    List<TaskDTO> sortTasksByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description) throws Exception;
    
}
