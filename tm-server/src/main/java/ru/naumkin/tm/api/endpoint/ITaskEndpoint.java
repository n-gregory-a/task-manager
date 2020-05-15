package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @NotNull
    @WebMethod
    List<Task> findAllTasks();

    @NotNull
    @WebMethod
    Task findOneTask(@Nullable final String name);

    @Nullable
    @WebMethod
    Task persistTask(@Nullable final Task task);

    @Nullable
    @WebMethod
    Task mergeTask(@Nullable final Task task, @Nullable final String name);

    @Nullable
    @WebMethod
    Task removeTask(@Nullable final Task task);

    @WebMethod
    void removeAllTasks();

    @WebMethod
    void loadTask(@NotNull final Task[] tasks);

    @NotNull
    @WebMethod
    List<Task> findAllTasksByUserId(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    Task findOneTaskByUserId(@Nullable final String currentUserId, @Nullable final String name);

    @NotNull
    @WebMethod
    Task removeTaskByUserId(@NotNull final String currentUserId, @NotNull final Task task);

    @WebMethod
    void removeAllTasksByUserId(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateStart(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateFinish(@Nullable final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByStatus(@NotNull final String currentUserId);

    @NotNull
    @WebMethod
    List<Task> sortTasksByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    @WebMethod
    List<Task> sortTasksByDescription(@NotNull final String currentUserId, @NotNull final String description);
    
}
