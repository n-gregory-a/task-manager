package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;

import java.util.List;

public final class TaskService extends AbstractService<Task> implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(@NotNull final ITaskRepository repository) {
        super(repository);
        this.taskRepository = repository;
    }

    @NotNull
    @Override
    public List<Task> findAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return taskRepository.findAll(currentUserId);
    }

    @NotNull
    @Override
    public Task findOne(
            @Nullable final String name,
            @Nullable final String currentUserId
    ) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @Nullable final Task task = taskRepository.findOne(name, currentUserId);
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    @NotNull
    @Override
    public Task remove(
            @Nullable final Task task,
            @Nullable final String currentUserId
    ) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        @Nullable final Task toRemove = taskRepository.remove(task, currentUserId);
        if (toRemove == null) {
            throw new TaskIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(@Nullable final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        taskRepository.removeAll(currentUserId);
    }

}