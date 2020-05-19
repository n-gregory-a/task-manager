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
    List<Task> findAllTasks(@Nullable final Session session);

    @NotNull
    @WebMethod
    Task findOneTask(@Nullable final Session session, @Nullable final String name);

    @Nullable
    @WebMethod
    Task persistTask(@Nullable final Session session, @Nullable final Task task);

    @Nullable
    @WebMethod
    Task mergeTask(
            @Nullable final Session session,
            @Nullable final Task task,
            @Nullable final String name);

    @Nullable
    @WebMethod
    Task removeTask(@Nullable final Session session, @Nullable final Task task);

    @WebMethod
    void removeAllTasks(@Nullable final Session session);

    @WebMethod
    void loadTask(@Nullable final Session session, @NotNull final Task[] tasks);

    @NotNull
    @WebMethod
    List<Task> findAllTasksByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    Task findOneTaskByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId,
            @Nullable final String name);

    @NotNull
    @WebMethod
    Task removeTaskByUserId(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final Task task);

    @WebMethod
    void removeAllTasksByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateStart(
            @Nullable final Session session,
            @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateFinish(
            @Nullable final Session session,
            @Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByStatus(
            @Nullable final Session session,
            @NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByName(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDescription(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String description);
    
}
