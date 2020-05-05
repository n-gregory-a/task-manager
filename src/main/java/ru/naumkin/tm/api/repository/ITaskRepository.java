package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository extends IRepository<Task> {

    List<Task> findAll(final String currentUserId);

    Task findOne(final String name, final String currentUserId);

    Task remove(final Task task, final String currentUserId);

    void removeAll(final String currentUserId);

}
