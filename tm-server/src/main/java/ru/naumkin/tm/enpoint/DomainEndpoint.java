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
public final class DomainEndpoint extends AbstractEndpoint implements IDomainEndpoint {

    @NotNull private IDomainService domainService;

    public DomainEndpoint(@NotNull final ServiceLocator serviceLocator) {
        super(serviceLocator);
        this.domainService = serviceLocator.getDomainService();
    }

    @Override
    @WebMethod
    public void loadBinaryData(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.loadBinaryData();
    }

    @Override
    @WebMethod
    public void saveBinaryData(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.saveBinaryData();
    }

    @Override
    @WebMethod
    public void loadJsonDataFasterXml(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.loadJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveJsonDataFasterXml(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.saveJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadJsonDataJaxb(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.loadJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void saveJsonDataJaxb(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.saveJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void loadXmlDataFasterXml(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.loadXmlDataFasterXml();
    }

    @Override
    public void saveXmlDataFasterXml(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.saveXmlDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadXmlDataJaxb(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
        domainService.loadXmlDataJaxb();
    }

    @Override
    @WebMethod
    public void saveXmlDataJaxb(@NotNull final String sessionToken)
            throws Exception {
        validate(sessionToken);
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
