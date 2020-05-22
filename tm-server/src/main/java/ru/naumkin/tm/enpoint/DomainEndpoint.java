package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IDomainEndpoint")
public final class DomainEndpoint extends AbstractEndpoint implements IDomainEndpoint {

    @NotNull private IDomainService domainService;

    public DomainEndpoint(
            @NotNull final ISessionService sessionService,
            @NotNull final IDomainService domainService
    ) {
        super(sessionService);
        this.domainService = domainService;
    }

    @Override
    @WebMethod
    public void loadBinaryData(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.loadBinaryData();
    }

    @Override
    @WebMethod
    public void saveBinaryData(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.saveBinaryData();
    }

    @Override
    @WebMethod
    public void loadJsonDataFasterXml(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.loadJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveJsonDataFasterXml(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.saveJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadJsonDataJaxb(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.loadJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void saveJsonDataJaxb(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.saveJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void loadXmlDataFasterXml(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.loadXmlDataFasterXml();
    }

    @Override
    public void saveXmlDataFasterXml(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.saveXmlDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadXmlDataJaxb(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.loadXmlDataJaxb();
    }

    @Override
    @WebMethod
    public void saveXmlDataJaxb(@NotNull final Session session)
            throws Exception {
        validate(session);
        domainService.saveXmlDataJaxb();
    }

    @NotNull
    @Override
    @WebMethod
    public Domain load() throws Exception {
        return domainService.load();
    }

    @Override
    @WebMethod
    public void save(@NotNull final Domain domain) throws Exception {
        domainService.save(domain);
    }

}
