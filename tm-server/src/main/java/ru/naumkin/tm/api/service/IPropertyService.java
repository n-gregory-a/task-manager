package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;

public interface IPropertyService {

    void init() throws Exception;

    @NotNull
    String getServerHost();

    @NotNull
    Integer getServerPort();

    @NotNull
    Integer getSessionCycle();

    @NotNull
    String getSessionSalt();

    @NotNull
    String getDbUrl();

    @NotNull
    String getDbUserName();

    @NotNull
    String getDbPassword();

}
