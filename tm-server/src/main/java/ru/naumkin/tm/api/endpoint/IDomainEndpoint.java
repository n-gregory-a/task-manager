package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.dto.Domain;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IDomainEndpoint {

    @NotNull
    @WebMethod
    Domain load(@NotNull final ServiceLocator serviceLocator);

    @WebMethod
    void save(@NotNull final ServiceLocator serviceLocator, Domain domain);

}
