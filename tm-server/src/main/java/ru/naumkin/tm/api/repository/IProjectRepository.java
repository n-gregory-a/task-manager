package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @NotNull
    List<Project> findAll() throws Exception;

    @NotNull
    List<Project> findAllByUserId(@NotNull final String userId) throws Exception;

    @Nullable
    Project findOne(@NotNull final String userId,
                    @NotNull final String name) throws Exception;

    void persist(@NotNull final Project project) throws Exception;

    void merge(@NotNull final Project project) throws Exception;

    void remove(@NotNull final String userId,
                @NotNull final String id) throws Exception;

    void removeAll(@NotNull final String userId) throws Exception;

    @NotNull
    List<Project> sortByDateStart(@NotNull final String userId) throws Exception;

    @NotNull
    List<Project> sortByDateFinish(@NotNull final String userId) throws Exception;

    @NotNull
    List<Project> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    List<Project> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
