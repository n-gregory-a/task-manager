package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository extends IRepository<Project> {

    List<Project> findAll(final String currentUserId);

    Project findOne(final String name, final String currentUserId);

    Project remove(final Project project, final String currentUserId);

    void removeAll(final String currentUserId);

}
