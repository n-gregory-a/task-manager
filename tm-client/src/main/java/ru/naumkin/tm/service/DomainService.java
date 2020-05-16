package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

import java.util.LinkedList;
import java.util.List;

public final class DomainService implements IDomainService {

    @NotNull
    @Override
    public Domain load(@NotNull final ServiceLocator serviceLocator) {
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        @NotNull Domain domain = new Domain();
        @NotNull final List<Project> projects = serviceLocator.getProjectService().findAll(currentUserId);
        @NotNull final List<Task> tasks = serviceLocator.getTaskService().findAll(currentUserId);
        @NotNull final List<User> users = new LinkedList<>(serviceLocator.getUserService().findAll());
        domain.setProjects(projects);
        domain.setTasks(tasks);
        domain.setUsers(users);
        return domain;
    }

    @Override
    public void save(
            @NotNull final ServiceLocator serviceLocator,
            @NotNull final Domain domain
    ) {
        boolean nullCheck = domain.getProjects() == null ||
                domain.getTasks() == null ||
                domain.getUsers() == null;
        if (nullCheck) {
            throw new RuntimeException();
        }
        for (@NotNull final Project project: domain.getProjects()) {
            serviceLocator.getProjectService().persist(project);
        }
        for (@NotNull final Task task: domain.getTasks()) {
            serviceLocator.getTaskService().persist(task);
        }
        for (@NotNull final User user: domain.getUsers()) {
            serviceLocator.getUserService().persist(user);
        }
    }

}
