package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectRepository {

    @NotNull
    List<Project> findAll(@NotNull final String currentUserId) throws SQLException;

    @Nullable
    Project findOne(@NotNull final String currentUserId, @NotNull final String name) throws SQLException;

    @Nullable
    Project persist(@NotNull final Project project) throws SQLException;

    @Nullable
    Project merge(@NotNull final Project project) throws SQLException;

    @Nullable
    Project remove(@NotNull final String currentUserId, @NotNull final Project project) throws SQLException;

    void removeAll(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByDateStart(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByDateFinish(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByStatus(@NotNull final String currentUserId) throws SQLException;

    @NotNull
    List<Project> sortByName(@NotNull final String currentUserId, @NotNull final String name) throws SQLException;

    @NotNull
    List<Project> sortByDescription(@NotNull final String currentUserId, @NotNull final String description) throws SQLException;

}
