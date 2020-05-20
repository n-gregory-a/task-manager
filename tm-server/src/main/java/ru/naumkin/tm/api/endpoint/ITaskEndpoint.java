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

    @NotNull
    @WebMethod
    List<Task> findAllTasks(@NotNull final Session session);

    @NotNull
    @WebMethod
    Task findOneTask(@NotNull final Session session, @NotNull final String name);

    @Nullable
    @WebMethod
    Task persistTask(@NotNull final Session session, @NotNull final Task task);

    @Nullable
    @WebMethod
    Task mergeTask(
            @NotNull final Session session,
            @NotNull final Task task,
            @NotNull final String name);

    @Nullable
    @WebMethod
    Task removeTask(@NotNull final Session session, @NotNull final Task task);

    @WebMethod
    void removeAllTasks(@NotNull final Session session);

    @WebMethod
    void loadTask(@NotNull final Session session, @NotNull final Task[] tasks);

    @NotNull
    @WebMethod
    List<Task> findAllTasksByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    Task findOneTaskByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name);

    @NotNull
    @WebMethod
    Task removeTaskByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final Task task);

    @WebMethod
    void removeAllTasksByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateStart(
            @NotNull final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateFinish(
            @NotNull final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByStatus(
            @NotNull final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByName(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDescription(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String description);
    
}
