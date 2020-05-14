package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.dto.Domain;

public interface IDomainService {

    @NotNull
    Domain load(@NotNull final ServiceLocator serviceLocator);

    void save(@NotNull final ServiceLocator serviceLocator, Domain domain);

}
