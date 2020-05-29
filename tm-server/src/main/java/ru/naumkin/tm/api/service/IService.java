package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.AbstractEntity;

import javax.persistence.EntityManagerFactory;

public interface IService<E extends AbstractEntity> {

    @NotNull
    EntityManagerFactory factory();

}