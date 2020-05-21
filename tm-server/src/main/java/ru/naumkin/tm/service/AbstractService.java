package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.entity.AbstractEntity;
import ru.naumkin.tm.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

@NoArgsConstructor
public abstract class AbstractService<E extends AbstractEntity> implements IService<E> {

    @NotNull
    private IPropertyService propertyService;

    public AbstractService(@NotNull final IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @NotNull
    public Connection getConnection() throws SQLException {
        @NotNull final String url = propertyService.getDbUrl();
        @NotNull final String userName = propertyService.getDbUserName();
        @NotNull final String password = propertyService.getDbPassword();
        return ConnectionUtil.getConnection(url, userName, password);
    }

}