package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.SQLException;

public interface IService<E extends AbstractEntity> {

    @NotNull
    Connection getConnection() throws SQLException, ClassNotFoundException;

}