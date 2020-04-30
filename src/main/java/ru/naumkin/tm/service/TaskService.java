package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.TaskRepository;

import java.util.Collection;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findAll(String currentUserId) {
        if (currentUserId == null) {
            throw new CurrentUserIdIsNullException();
        }
        if (currentUserId.isEmpty()) {
            throw new CurrentUserIdIsEmptyException();
        }
        return taskRepository.findAll(currentUserId);
    }

    public Task findOne(String name, String currentUserId) {
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
        return taskRepository.findOne(name, currentUserId);
    }

    public Task findOne(String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        Task task = taskRepository.findOne(name);
        if (task == null) {
            throw new NoTaskWithSuchNameException(name);
        }
        return task;
    }

    public void persist(Task task) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        taskRepository.persist(task);
    }

    public void merge(Task task, String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (task == null) {
            throw new TaskIsNullException();
        }
        if (task.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        Task updatingTask = taskRepository.findOne(name);
        if (updatingTask == null){
            taskRepository.persist(task);
        }
        taskRepository.merge(task, name);
    }

    public void remove(Task task) {
        if (task == null) {
            throw new TaskIsNullException();
        }
        taskRepository.remove(task);
    }

    public void removeAll() {
        taskRepository.removeAll();
    }

}