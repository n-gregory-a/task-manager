package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface ITaskEndpoint {

    @Nullable
    @WebMethod
    Task persistTask(@NotNull final Session session, @NotNull final Task task) throws SQLException;

    @Nullable
    @WebMethod
    Task mergeTask(
            @NotNull final Session session,
            @NotNull final Task task,
            @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> findAllTasksByUserId(
            @NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    Task findOneTaskByUserId(
            @NotNull final Session session,
            @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    Task removeTaskByUserId(
            @NotNull final Session session,
            @NotNull final Task task) throws SQLException;

    @WebMethod
    void removeAllTasksByUserId(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateStart(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDateFinish(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> sortTasksByStatus(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> sortTasksByName(
            @NotNull final Session session,
            @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    List<Task> sortTasksByDescription(
            @NotNull final Session session,
            @NotNull final String description) throws SQLException;
    
}
