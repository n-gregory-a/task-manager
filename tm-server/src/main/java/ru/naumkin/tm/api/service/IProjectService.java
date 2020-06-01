package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectService extends IService<Project> {

    @NotNull
    List<Project> findAll() throws Exception;

    @NotNull
    List<Project> findAllByUserId(@Nullable final String userId);

    @NotNull
    Project findOneByUserId(@Nullable final String userId, @Nullable final String name);

    void persist(@NotNull final Project project);

    void merge(@NotNull final Project project);

    void remove(@NotNull final String userId, @NotNull final Project project);

    void removeAllByUserId(@Nullable final String userId);

    @NotNull
    List<Project> sortByDateStart(@Nullable final String userId);

    @NotNull
    List<Project> sortByDateFinish(@Nullable final String userId);

    @NotNull
    List<Project> sortByStatus(@NotNull final String userId);

    @NotNull
    List<Project> sortByName(@NotNull final String userId, @NotNull final String name);

    @NotNull
    List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description);

}
