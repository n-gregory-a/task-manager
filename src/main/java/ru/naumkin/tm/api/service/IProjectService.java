package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectService extends IService<Project> {

    List<Project> findAll(String currentUserId);

    Project findOne(String name, String currentUserId);

    Project remove(Project project, String currentUserId);

    void removeAll(String currentUserId);

}
