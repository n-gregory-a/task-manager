package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;

import java.util.List;

@NoArgsConstructor
public final class TaskService extends AbstractService<Task> implements ITaskService {

    @NotNull
    private ITaskRepository taskRepository;

    public TaskService(@NotNull final ITaskRepository repository) {
        super(repository);
        this.taskRepository = repository;
    }

    @NotNull
    @Override
    public List<Task> findAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.findAll(currentUserId);
    }

    @NotNull
    @Override
    public Task findOne(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        if (name == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (name.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        @Nullable final Task task = taskRepository.findOne(currentUserId, name);
        if (task == null) {
            throw new RuntimeException();
        }
        return task;
    }

    @NotNull
    @Override
    public Task remove(
            @Nullable final String currentUserId,
            @Nullable final Task task
    ) {
        if (task == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        @Nullable final Task toRemove = taskRepository.remove(currentUserId, task);
        if (toRemove == null) {
            throw new RuntimeException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        taskRepository.removeAll(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateStart(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.sortByDateStart(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByDateFinish(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.sortByDateFinish(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByStatus(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.sortByStatus(currentUserId);
    }

    @NotNull
    @Override
    public List<Task> sortByName(
            @Nullable final String currentUserId,
            @Nullable final String name
    ) {
        if (name == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (name.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.sortByName(currentUserId, name);
    }

    @NotNull
    @Override
    public List<Task> sortByDescription(
            @Nullable final String currentUserId,
            @Nullable final String description
    ) {
        if (description == null) {
            throw new RuntimeException();
        }
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        if (description.isEmpty()) {
            throw new RuntimeException();
        }
        if (currentUserId.isEmpty()) {
            throw new RuntimeException();
        }
        return taskRepository.sortByDescription(currentUserId, description);
    }

}