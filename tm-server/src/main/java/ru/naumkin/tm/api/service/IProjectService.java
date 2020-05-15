package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectService extends IService<Project> {

    @NotNull
    List<Project> findAll(@Nullable final String currentUserId);

    @NotNull
    Project findOne(@Nullable final String name, @Nullable final String currentUserId);

    @NotNull
    Project remove(final Project project, final String currentUserId);

    void removeAll(@Nullable final String currentUserId);

    @NotNull
    List<Project> sortByDateStart(@Nullable final String currentUserId);

    @NotNull
    List<Project> sortByDateFinish(@Nullable final String currentUserId);

    @NotNull
    List<Project> sortByStatus(@NotNull final String currentUserId);

    @NotNull
    List<Project> sortByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    List<Project> sortByDescription(@NotNull final String currentUserId, @NotNull final String description);

}
