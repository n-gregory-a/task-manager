package ru.naumkin.tm.service;

import ru.naumkin.tm.api.repository.ITaskRepository;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;

import java.util.List;

public final class TaskService extends AbstractService<Task> implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(final ITaskRepository repository) {
        super(repository);
        this.taskRepository = repository;
    }

    @Override
    public List<Task> findAll(final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return taskRepository.findAll(currentUserId);
    }

    @Override
    public Task findOne(final String name, final String currentUserId) {
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
        final Task task = taskRepository.findOne(name, currentUserId);
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    @Override
    public Task remove(final Task task, final String currentUserId) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        final Task toRemove = taskRepository.remove(task, currentUserId);
        if (toRemove == null) {
            throw new TaskIsNullException();
        }
        return toRemove;
    }

    @Override
    public void removeAll(final String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        taskRepository.removeAll(currentUserId);
    }
}