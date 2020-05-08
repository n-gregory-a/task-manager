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

}
