package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;

import javax.jws.WebService;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.ITaskEndpoint")
public class TaskEndpoint implements ITaskEndpoint {

    @NotNull private ITaskService taskService;

    public TaskEndpoint(@NotNull ITaskService taskService) {
        this.taskService = taskService;
    }

    @NotNull
    @Override
    public List<Task> findAllTasks() {
        return (List<Task>) taskService.findAll();
    }

    @NotNull
    @Override
    public Task findOneTask(@Nullable final String name) {
        return taskService.findOne(name);
    }

    @Nullable
    @Override
    public Task persistTask(@Nullable final Task task) {
        return taskService.persist(task);
    }

    @Nullable
    @Override
    public Task mergeTask(
            @Nullable final Task task,
            @Nullable final String name
    ) {
        return taskService.merge(task, name);
    }

    @Nullable
    @Override
    public Task removeTask(@Nullable final Task task) {
        return taskService.remove(task);
    }

    @Override
    public void removeAllTasks() {
        taskService.removeAll();
    }

    @Override
    public void loadTask(@NotNull final Task[] tasks) {
        taskService.load(tasks);
    }

    @NotNull
    @Override
    public List<Task> findAllTasksByUserId(@Nullable final String currentUserId) {
        return taskService.findAll(currentUserId);
    }

    @NotNull
    @Override
    public Task findOneTaskByUserId(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        return taskService.findOne(currentUserId, name);
    }

    @NotNull
    @Override
    public Task removeTaskByUserId(
            @NotNull final String currentUserId,
            @NotNull final Task task
    ) {
        return taskService.remove(currentUserId, task);
    }

    @Override
    public void removeAllTasksByUserId(@Nullable final String currentUserId) {
        taskService.removeAll(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortTasksByDateStart(@Nullable final String currentUserId) {
        return taskService.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortTasksByDateFinish(@Nullable final String currentUserId) {
        return taskService.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortTasksByStatus(@NotNull final String currentUserId) {
        return taskService.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortTasksByName(
            @NotNull final String currentUserId,
            @NotNull final String name
    ) {
        return taskService.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    public List<Task> sortTasksByDescription(
            @NotNull final String currentUserId,
            @NotNull final String description
    ) {
        return taskService.sortByDescription(currentUserId, description);
    }

}
