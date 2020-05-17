package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IDomainEndpoint {

    @WebMethod
    void loadBinaryData() throws Exception;

    @WebMethod
    void saveBinaryData() throws Exception;

    @WebMethod
    void loadJsonDataFasterXml() throws Exception;

    @WebMethod
    void saveJsonDataFasterXml() throws Exception;

    @WebMethod
    void loadJsonDataJaxb() throws Exception;

    @WebMethod
    void saveJsonDataJaxb() throws Exception;

    @WebMethod
    void loadXmlDataFasterXml() throws Exception;

    @WebMethod
    void saveXmlDataFasterXml() throws Exception;

    @WebMethod
    void loadXmlDataJaxb() throws Exception;

    @WebMethod
    void saveXmlDataJaxb() throws Exception;

    @NotNull
    @WebMethod
    Domain load();

    @WebMethod
    void save(@NotNull final Domain domain);

}
