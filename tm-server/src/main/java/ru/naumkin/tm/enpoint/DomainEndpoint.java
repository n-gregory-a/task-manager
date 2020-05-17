package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.dto.Domain;

import javax.jws.WebMethod;
import javax.jws.WebService;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IDomainEndpoint")
public final class DomainEndpoint implements IDomainEndpoint {

    @NotNull private IDomainService domainService;

    public DomainEndpoint(@NotNull final IDomainService domainService) {
        this.domainService = domainService;
    }

    @NotNull
    @Override
    @WebMethod
    public Domain load(@NotNull final ServiceLocator serviceLocator) {
        return domainService.load(serviceLocator);
    }

    @Override
    @WebMethod
    public void save(@NotNull final ServiceLocator serviceLocator, @NotNull final Domain domain) {
        domainService.save(serviceLocator, domain);
    }

}
