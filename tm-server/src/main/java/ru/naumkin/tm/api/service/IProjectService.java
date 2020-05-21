package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectService extends IService<Project> {

    @NotNull
    List<Project> findAll(@Nullable final String currentUserId) throws SQLException;

    @NotNull
    Project findOne(@Nullable final String currentUserId, @Nullable final String name) throws SQLException;

    @Nullable
    Project persist(@NotNull final Project project) throws SQLException;

    @Nullable
    Project merge(@NotNull final Project project) throws SQLException;

    @NotNull
    Project remove(@NotNull final String currentUserId, @NotNull final Project project) throws SQLException;

    void removeAll(@Nullable final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByDateStart(@Nullable final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByDateFinish(@Nullable final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByStatus(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByName(@NotNull final String currentUserId, @NotNull final String name) throws SQLException;

    @NotNull
    List<Project> sortByDescription(@NotNull final String currentUserId, @NotNull final String description) throws SQLException;

}
