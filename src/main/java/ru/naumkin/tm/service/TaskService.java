package ru.naumkin.tm.service;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.repository.TaskRepository;

import java.util.Collection;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findOne(String name) {
        return taskRepository.findOne(name);
    }

    public void persist(Task task) {
        taskRepository.persist(task);
    }

    public void merge(Task task, String name) {
        taskRepository.merge(task, name);
    }

    public void remove(Task task) {
        taskRepository.remove(task);
    }

    public void removeAll() {
        taskRepository.removeAll();
    }

}
