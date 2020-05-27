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
    
    @NotNull private ISessionService sessionService;

    public TaskEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final ITaskService taskService) {
        super(sessionService);
        this.taskService = taskService;
        this.sessionService = sessionService;
    }

    @Override
    @WebMethod
    public void persistTask(
            @NotNull final String sessionToken,
            @NotNull final Task task
    ) throws Exception {
        validate(sessionToken);
        taskService.persist(task);
    }

    @Override
    @WebMethod
    public void mergeTask(
            @NotNull final String sessionToken,
            @NotNull final Task task
    ) throws Exception {
        validate(sessionToken);
        taskService.merge(task);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> findAllTasksByUserId(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        return taskService.findAll(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public Task findOneTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        return taskService.findOne(sessionService.getUserId(sessionToken), name);
    }

    @Override
    @WebMethod
    public void removeTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final Task task
    ) throws Exception {
        validate(sessionToken);
        taskService.remove(sessionService.getUserId(sessionToken), task);
    }

    @Override
    @WebMethod
    public void removeAllTasksByUserId(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        taskService.removeAll(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateStart(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        return taskService.sortByDateStart(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDateFinish(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        return taskService.sortByDateFinish(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByStatus(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        return taskService.sortByStatus(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByName(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        return taskService.sortByName(sessionService.getUserId(sessionToken), name);
    }

    @NotNull
    @Override
    @WebMethod
    public List<Task> sortTasksByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description
    ) throws Exception {
        validate(sessionToken);
        return taskService.sortByDescription(sessionService.getUserId(sessionToken), description);
    }

}
