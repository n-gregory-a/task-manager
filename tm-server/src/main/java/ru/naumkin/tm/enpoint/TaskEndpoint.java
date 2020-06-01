package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.dto.TaskDTO;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.ITaskEndpoint")
public final class TaskEndpoint extends AbstractEndpoint implements ITaskEndpoint {

    @NotNull private ITaskService taskService;
    
    @NotNull private ISessionService sessionService;

    public TaskEndpoint(@NotNull final ServiceLocator serviceLocator) {
        super(serviceLocator);
        this.taskService = serviceLocator.getTaskService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public void persistTask(
            @NotNull final String sessionToken,
            @NotNull final TaskDTO taskDTO
    ) throws Exception {
        validate(sessionToken);
        taskService.persist(taskDTO.convertToTask(taskDTO, serviceLocator));
    }

    @Override
    @WebMethod
    public void mergeTask(
            @NotNull final String sessionToken,
            @NotNull final TaskDTO taskDTO
    ) throws Exception {
        validate(sessionToken);
        taskService.merge(taskDTO.convertToTask(taskDTO, serviceLocator));
    }

    @NotNull
    @Override
    @WebMethod
    public List<TaskDTO> findAllTasksByUserId(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.findAll(sessionService.getUserId(sessionToken));
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public TaskDTO findOneTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        @NotNull final Task task =
                taskService.findOne(sessionService.getUserId(sessionToken), name);
        return task.convertToTaskDTO(task);
    }

    @Override
    @WebMethod
    public void removeTaskByUserId(
            @NotNull final String sessionToken,
            @NotNull final TaskDTO taskDTO
    ) throws Exception {
        validate(sessionToken);
        @NotNull final Task task = taskDTO.convertToTask(taskDTO, serviceLocator);
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
    public List<TaskDTO> sortTasksByDateStart(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.sortByDateStart(sessionService.getUserId(sessionToken));
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<TaskDTO> sortTasksByDateFinish(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.sortByDateFinish(sessionService.getUserId(sessionToken));
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<TaskDTO> sortTasksByStatus(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.sortByStatus(sessionService.getUserId(sessionToken));
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<TaskDTO> sortTasksByName(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.sortByName(sessionService.getUserId(sessionToken), name);
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<TaskDTO> sortTasksByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Task> tasks =
                taskService.sortByDescription(sessionService.getUserId(sessionToken), description);
        @NotNull final List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            @NotNull final TaskDTO taskDTO = task.convertToTaskDTO(task);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

}
