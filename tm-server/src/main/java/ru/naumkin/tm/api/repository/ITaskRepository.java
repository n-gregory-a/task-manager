package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @NotNull
    List<Task> findAll() throws Exception;

    @NotNull
    List<Task> findAllByUserId(@NotNull final String userId) throws Exception;

    @Nullable
    Task findOneByUserId(@NotNull final String userId,
                         @NotNull final String name) throws Exception;

    void persist(@NotNull final Task task) throws Exception;

    void merge(@NotNull final Task task) throws Exception;

    void remove(@NotNull final String userId,
                @NotNull final String id) throws Exception;

    void removeAll(@NotNull final String userId) throws Exception;

    @NotNull
    List<Task> sortByDateStart(@NotNull final String userId) throws Exception;

    @NotNull
    List<Task> sortByDateFinish(@NotNull final String userId) throws Exception;

    @NotNull
    List<Task> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
