package ru.naumkin.tm.service;

import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.entity.AbstractEntity;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.*;

import java.util.Collection;

public abstract class AbstractService<E extends AbstractEntity> implements IService<E> {

    protected IRepository<E> repository;

    public AbstractService(IRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public Collection<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findOne(String name) {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        E entity = repository.findOne(name);
        if (entity == null) {
            doThrow(entity, name);
        }
        return entity;
    }

    @Override
    public E persist(E entity) {
        if (entity == null) {
            doThrow(entity);
        }
        return repository.persist(entity);
    }

    @Override
    public E merge(E entity, String name) {
        if (name == null) {
            throw new NameIsEmptyException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (entity == null) {
            doThrow(entity);
        }
        if (entity.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        E updatingEntity = repository.findOne(name);
        if (updatingEntity == null) {
            return repository.persist(entity);
        }
        return repository.merge(entity);
    }

    @Override
    public E remove(E entity) {
        if (entity == null) {
            doThrow(entity);
        }
        return repository.remove(entity);
    }

    @Override
    public void removeAll() {
        repository.removeAll();
    }

    protected void doThrow(E entity, String name) {
        if (entity.getClass() == Project.class) {
            throw new NoProjectWithSuchNameException(name);
        }
        if (entity.getClass() == Task.class) {
            throw new NoTaskWithSuchNameException(name);
        }
        if (entity.getClass() == User.class) {
            throw new NoUserWithSuchLoginException(name);
        }
    }

    protected void doThrow(E entity) {
        if (entity.getClass() == Project.class) {
            throw new ProjectIsNullException();
        }
        if (entity.getClass() == Task.class) {
            throw new TaskIsNullException();
        }
        if (entity.getClass() == User.class) {
            throw new UserIsNullException();
        }
    }

}
