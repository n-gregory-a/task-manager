package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IService<E extends AbstractEntity> {

    @NotNull
    Collection<E> findAll();

    @NotNull
    E findOne(@Nullable final String name);

    @Nullable
    E persist(@Nullable final E entity);

    @Nullable
    E merge(@Nullable final E entity, @Nullable final String name);

    @Nullable
    E remove(@Nullable final E entity);

    void removeAll();

    void persist(E[] entities);

}
