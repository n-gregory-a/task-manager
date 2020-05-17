package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
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

    @Override
    @WebMethod
    public void loadBinaryData() throws Exception {
        domainService.loadBinaryData();
    }

    @Override
    @WebMethod
    public void saveBinaryData() throws Exception {
        domainService.saveBinaryData();
    }

    @Override
    @WebMethod
    public void loadJsonDataFasterXml() throws Exception {
        domainService.loadJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void saveJsonDataFasterXml() throws Exception {
        domainService.saveJsonDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadJsonDataJaxb() throws Exception {
        domainService.loadJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void saveJsonDataJaxb() throws Exception {
        domainService.saveJsonDataJaxb();
    }

    @Override
    @WebMethod
    public void loadXmlDataFasterXml() throws Exception {
        domainService.loadXmlDataFasterXml();
    }

    @Override
    public void saveXmlDataFasterXml() throws Exception {
        domainService.saveXmlDataFasterXml();
    }

    @Override
    @WebMethod
    public void loadXmlDataJaxb() throws Exception {
        domainService.loadXmlDataJaxb();
    }

    @Override
    @WebMethod
    public void saveXmlDataJaxb() throws Exception {
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
