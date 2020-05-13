package ru.naumkin.tm.api.service;

import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.dto.Domain;

public interface IDomainService {

    Domain load(ServiceLocator serviceLocator);

    void save(ServiceLocator serviceLocator, Domain domain);

}
