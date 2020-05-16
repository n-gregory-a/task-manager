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

}
