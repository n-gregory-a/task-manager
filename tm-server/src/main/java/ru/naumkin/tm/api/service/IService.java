package ru.naumkin.tm.api.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.AbstractEntity;

public interface IService<E extends AbstractEntity> {

    @NotNull
    SqlSessionFactory getSqlSessionFactory();

}