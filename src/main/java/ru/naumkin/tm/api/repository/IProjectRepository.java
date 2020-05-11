package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository extends IRepository<Project> {

    @NotNull
    List<Project> findAll(@NotNull final String currentUserId);

    @Nullable
    Project findOne(@NotNull final String name, @NotNull final String currentUserId);

    @Nullable
    Project remove(@NotNull final Project project, @NotNull final String currentUserId);

    void removeAll(@NotNull final String currentUserId);

    @NotNull
    List<Project> sortByDateStart(@NotNull final String currentUserId);

    @NotNull
    List<Project> sortByDateFinish(@NotNull final String currentUserId);

    @NotNull
    List<Project> sortByStatus(@NotNull final String currentUserId);

    @NotNull
    List<Project> sortByName(@NotNull final String currentUserId, @NotNull final String name);

    @NotNull
    List<Project> sortByDescription(@NotNull final String currentUserId, @NotNull final String description);

}
