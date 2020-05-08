package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.entity.AbstractEntity;
import ru.naumkin.tm.error.EntityIsNullException;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;

import java.util.Collection;

@NoArgsConstructor
public abstract class AbstractService<E extends AbstractEntity> implements IService<E> {

    protected IRepository<E> repository;

    public AbstractService(final @NotNull IRepository<E> repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Collection<E> findAll() {
        return repository.findAll();
    }

    @NotNull
    @Override
    public E findOne(@Nullable final String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        @Nullable E entity = repository.findOne(name);
        if (entity == null) {
            throw new EntityIsNullException();
        }
        return entity;
    }

    @Nullable
    @Override
    public E persist(@Nullable final E entity) {
        if (entity == null) {
            throw new EntityIsNullException();
        }
        return repository.persist(entity);
    }

    @Nullable
    @Override
    public E merge(final @Nullable E entity, final @Nullable String name) {
        if (name == null) {
            throw new NameIsEmptyException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (entity == null) {
            throw new EntityIsNullException();
        }
        if (entity.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        @Nullable final E updatingEntity = repository.findOne(name);
        if (updatingEntity == null) {
            return repository.persist(entity);
        }
        return repository.merge(entity);
    }

    @Nullable
    @Override
    public E remove(final @Nullable E entity) {
        if (entity == null) {
            throw new EntityIsNullException();
        }
        return repository.remove(entity);
    }

    @Override
    public void removeAll() {
        repository.removeAll();
    }

}
