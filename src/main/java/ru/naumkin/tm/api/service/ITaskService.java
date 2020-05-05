package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskService extends IService<Task> {

    List<Task> findAll(final String currentUserId);

    Task findOne(final String name, final String currentUserId);

    Task remove(final Task task, final String currentUserId);

    void removeAll(final String currentUserId);

}
