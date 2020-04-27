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
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        }
        Task task = taskRepository.findOne(name);
        if (task != null) {
            return task;
        } else {
            throw new NullPointerException("There is no task with name " + name);
        }
    }

    public void persist(Task task) {
        if (task != null) {
            taskRepository.persist(task);
        } else {
            throw new NullPointerException("There is no task to persist");
        }
    }

    public void merge(Task task, String name) {
        if (name.isEmpty() || task.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty, updating failed");
        }

        Task updatingTask = taskRepository.findOne(name);
        if (updatingTask != null) {
            taskRepository.merge(task, name);
        } else {
            taskRepository.persist(task);
        }
    }

    public void remove(Task task) {
        if (task != null) {
            taskRepository.remove(task);
        } else {
            throw new NullPointerException("There is no task to remove");
        }
    }

    public void removeAll() {
        taskRepository.removeAll();
    }

}
