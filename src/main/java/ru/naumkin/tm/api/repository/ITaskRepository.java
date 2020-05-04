package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository extends IRepository<Task> {

    List<Task> findAll(String currentUserId);

    Task findOne(String name, String currentUserId);

    Task remove(Task task, String currentUserId);

    void removeAll(String currentUserId);

}
