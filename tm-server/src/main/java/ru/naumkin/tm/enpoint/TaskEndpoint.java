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
    public List<Task> findAllTasks(@Nullable final Session session) {
        return new LinkedList<>(taskService.findAll());
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTask(
            @Nullable final Session session,
            @Nullable final String name
    ) {
        return taskService.findOne(name);
    }

    @Nullable
    @Override
    @WebMethod
    public Task persistTask(
            @Nullable final Session session,
            @Nullable final Task task
    ) {
        return taskService.persist(task);
    }

    @Nullable
    @Override
    @WebMethod
    public Task mergeTask(
            @Nullable final Session session,
            @Nullable final Task task,
            @Nullable final String name
    ) {
        return taskService.merge(task, name);
    }

    @Nullable
    @Override
    @WebMethod
    public Task removeTask(
            @Nullable final Session session,
            @Nullable final Task task
    ) {
        return taskService.remove(task);
    }

    @Override
    @WebMethod
    public void removeAllTasks(@Nullable final Session session) {
        taskService.removeAll();
    }

    @Override
    @WebMethod
    public void loadTask(
            @Nullable final Session session,
            @NotNull final Task[] tasks
    ) {
        taskService.persist(tasks);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> findAllTasksByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        return taskService.findAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTaskByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        return taskService.findOne(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public Task removeTaskByUserId(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final Task task
    ) {
        return taskService.remove(currentUserId, task);
    }

    @Override
    @WebMethod
    public void removeAllTasksByUserId(
            @Nullable final Session session,
            @Nullable final String currentUserId) {
        taskService.removeAll(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateStart(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        return taskService.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateFinish(
            @Nullable final Session session,
            @Nullable final String currentUserId
    ) {
        return taskService.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByStatus(
            @Nullable final Session session,
            @NotNull final String currentUserId
    ) {
        return taskService.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByName(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        return taskService.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDescription(
            @Nullable final Session session,
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        return taskService.sortByDescription(currentUserId, description);
    }

}
