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

    @Override
    @WebMethod
    public void persistTask(
            @NotNull final Session session,
            @NotNull final Task task
    ) throws Exception {
        validate(session);
        taskService.persist(task);
    }

    @Override
    @WebMethod
    public void mergeTask(
            @NotNull final Session session,
            @NotNull final Task task
    ) throws Exception {
        validate(session);
        taskService.merge(task);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> findAllTasksByUserId(@NotNull final Session session) throws Exception {
        validate(session);
        return taskService.findAll(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTaskByUserId(
            @NotNull final Session session,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        return taskService.findOne(session.getUserId(), name);
    }

    @Override
    @WebMethod
    public void removeTaskByUserId(
            @NotNull final Session session,
            @NotNull final Task task
    ) throws Exception {
        validate(session);
        taskService.remove(session.getUserId(), task);
    }

    @Override
    @WebMethod
    public void removeAllTasksByUserId(@NotNull final Session session) throws Exception {
        validate(session);
        taskService.removeAll(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateStart(@NotNull final Session session) throws Exception {
        validate(session);
        return taskService.sortByDateStart(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateFinish(@NotNull final Session session) throws Exception {
        validate(session);
        return taskService.sortByDateFinish(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByStatus(@NotNull final Session session) throws Exception {
        validate(session);
        return taskService.sortByStatus(session.getUserId());
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByName(
            @NotNull final Session session,
            @NotNull final String name
    ) throws Exception {
        validate(session);
        return taskService.sortByName(session.getUserId(), name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDescription(
            @NotNull final Session session,
            @NotNull final String description
    ) throws Exception {
        validate(session);
        return taskService.sortByDescription(session.getUserId(), description);
    }

}
