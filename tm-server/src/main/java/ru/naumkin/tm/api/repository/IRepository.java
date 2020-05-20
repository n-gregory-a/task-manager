package ru.naumkin.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IRepository<E extends AbstractEntity> {

    @NotNull
    Collection<E> findAll();

    @NotNull
    E findOne(@NotNull final String name);

    @NotNull
    E findOneById(@NotNull final String id);

    @Nullable
    E persist(@NotNull final E entity);

    @Nullable
    E merge(@NotNull final E entity);

    @Nullable
    E remove(@NotNull final E entity);

    void removeAll();

    void persist(E[] entities);

}
