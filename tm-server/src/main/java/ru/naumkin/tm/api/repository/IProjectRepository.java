package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @NotNull
    List<Project> findAll();

    @NotNull
    List<Project> findAllByUserId(@NotNull final String userId);

    @Nullable
    Project findOneByUserId(@NotNull final String userId, @NotNull final String name);

    @Nullable
    Project findOneId(@NotNull final String userId, @NotNull final String id);

    void persist(@NotNull final Project project);

    void merge(@NotNull final Project project);

    void remove(@NotNull final String userId, @NotNull final String id);

    void removeAllByUserId(@NotNull final String userId);

    @NotNull
    List<Project> sortByDateStart(@NotNull final String userId);

    @NotNull
    List<Project> sortByDateFinish(@NotNull final String userId);

    @NotNull
    List<Project> sortByStatus(@NotNull final String userId);

    @NotNull
    List<Project> sortByName(@NotNull final String userId, @NotNull final String name);

    @NotNull
    List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description);

}
