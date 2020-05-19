package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
    public void loadBinaryData(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.loadBinaryData();
    }

    @Override
    @WebMethod
    public void saveBinaryData(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.saveBinaryData();
    }

    @Override
    @WebMethod
    public void loadJsonDataFasterXml(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.loadJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveJsonDataFasterXml(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.saveJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadJsonDataJaxb(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.loadJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void saveJsonDataJaxb(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.saveJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void loadXmlDataFasterXml(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.loadXmlDataFasterXml();
    }

    @Override
    public void saveXmlDataFasterXml(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.saveXmlDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadXmlDataJaxb(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.loadXmlDataJaxb();
    }

    @Override
    @WebMethod
    public void saveXmlDataJaxb(@Nullable final Session session) throws Exception {
        validate(session);
        domainService.saveXmlDataJaxb();
    }

    @NotNull
    @Override
    @WebMethod
    public Domain load() {
        return domainService.load();
    }

    @Override
    @WebMethod
    public void save(@NotNull Domain domain) {
        domainService.save(domain);
    }

}
