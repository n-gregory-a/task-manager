package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @WebMethod
    void persistTask(@NotNull final String sessionToken, @NotNull final Task task) throws Exception;

    @WebMethod
    void mergeTask(
            @NotNull final String sessionToken,
            @NotNull final Task task) throws Exception;

    @NotNull
    @WebMethod
    List<Task> findAllTasksByUserId(
            @NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    Task findOneTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name) throws Exception;

    @WebMethod
    void removeTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final Task task) throws Exception;

    @WebMethod
    void removeAllTasksByUserId(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateStart(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateFinish(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Task> sortTasksByStatus(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    List<Task> sortTasksByName(
            @NotNull final String sessionToken,
            @NotNull final String name) throws Exception;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description) throws Exception;
    
}
