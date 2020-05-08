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

}
