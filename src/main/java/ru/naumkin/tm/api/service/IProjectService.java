package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectService extends IService<Project> {

    List<Project> findAll(final String currentUserId);

    Project findOne(final String name, final String currentUserId);

    Project remove(final Project project, final String currentUserId);

    void removeAll(final String currentUserId);

}
