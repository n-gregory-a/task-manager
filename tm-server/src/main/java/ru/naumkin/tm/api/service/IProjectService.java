package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectService extends IService<Project> {

    @NotNull
    List<Project> findAll() throws Exception;

    @NotNull
    List<Project> findAll(@Nullable final String userId) throws Exception;

    @NotNull
    Project findOne(@Nullable final String userId, @Nullable final String name) throws Exception;

    void persist(@NotNull final Project project) throws Exception;

    void merge(@NotNull final Project project) throws Exception;

    void remove(@NotNull final String userId, @NotNull final Project project) throws Exception;

    void removeAll(@Nullable final String userId) throws Exception;

    @NotNull
    List<Project> sortByDateStart(@Nullable final String userId) throws Exception;

    @NotNull
    List<Project> sortByDateFinish(@Nullable final String userId) throws Exception;

    @NotNull
    List<Project> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    List<Project> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
