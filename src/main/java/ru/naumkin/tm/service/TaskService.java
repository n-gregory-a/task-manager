package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.repository.TaskRepository;

import java.util.Collection;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findOne(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name is null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        }
        Task task = taskRepository.findOne(name);
        if (task == null) {
            throw new NullPointerException("There is no task with name " + name);
        }
        return task;
    }

    public void persist(Task task) {
        if (task == null) {
            throw new NullPointerException("There is no task to persist");
        }
        taskRepository.persist(task);
    }

    public void merge(Task task, String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name is null, updating failed");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }
        if (task == null) {
            throw new NullPointerException("There is no task to merge");
        }
        if (task.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }
        Task updatingTask = taskRepository.findOne(name);
        if (updatingTask == null){
            taskRepository.persist(task);
        }
        taskRepository.merge(task, name);
    }

    public void remove(Task task) {
        if (task == null) {
            throw new NullPointerException("There is no task to remove");
        }
        taskRepository.remove(task);
    }

    public void removeAll() {
        taskRepository.removeAll();
    }

}