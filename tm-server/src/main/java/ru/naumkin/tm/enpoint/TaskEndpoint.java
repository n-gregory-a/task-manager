package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.ITaskEndpoint")
public final class TaskEndpoint extends AbstractEndpoint implements ITaskEndpoint {

    @NotNull private ITaskService taskService;

    public TaskEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final ITaskService taskService) {
        super(sessionService);
        this.taskService = taskService;
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> findAllTasks(@NotNull final Session session) {
        return new LinkedList<>(taskService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTask(
            @NotNull final Session session,
            @NotNull final String name
    ) {
        validate(session);
        return taskService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Task persistTask(
            @NotNull final Session session,
            @NotNull final Task task
    ) {
        validate(session);
        return taskService.persist(task);
    }

    @Nullable
    @Override
    @WebMethod
    public Task mergeTask(
            @NotNull final Session session,
            @NotNull final Task task,
            @NotNull final String name
    ) {
        validate(session);
        return taskService.merge(task, name);
    }

    @Nullable
    @Override
    @WebMethod
    public Task removeTask(
            @NotNull final Session session,
            @NotNull final Task task
    ) {
        validate(session);
        return taskService.remove(task);
    }

    @Override
    @WebMethod
    public void removeAllTasks(@NotNull final Session session) {
        validate(session);
        taskService.removeAll();
    }

    @Override
    @WebMethod
    public void loadTask(
            @NotNull final Session session,
            @NotNull final Task[] tasks
    ) {
        validate(session);
        taskService.persist(tasks);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> findAllTasksByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId
    ) {
        validate(session);
        return taskService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTaskByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        validate(session);
        return taskService.findOne(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public Task removeTaskByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final Task task
    ) {
        validate(session);
        return taskService.remove(currentUserId, task);
    }

    @Override
    @WebMethod
    public void removeAllTasksByUserId(
            @NotNull final Session session,
            @NotNull final String currentUserId) {
        validate(session);
        taskService.removeAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateStart(
            @NotNull final Session session,
            @NotNull final String currentUserId
    ) {
        validate(session);
        return taskService.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateFinish(
            @NotNull final Session session,
            @NotNull final String currentUserId
    ) {
        validate(session);
        return taskService.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByStatus(
            @NotNull final Session session,
            @NotNull final String currentUserId
    ) {
        validate(session);
        return taskService.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByName(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        validate(session);
        return taskService.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDescription(
            @NotNull final Session session,
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        validate(session);
        return taskService.sortByDescription(currentUserId, description);
    }

}
