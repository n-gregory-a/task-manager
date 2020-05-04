package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository extends IRepository<Project> {

    List<Project> findAll(String currentUserId);

    Project findOne(String name, String currentUserId);

    Project remove(Project project, String currentUserId);

    void removeAll(String currentUserId);

}
