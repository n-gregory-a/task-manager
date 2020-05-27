package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IDomainEndpoint {

    @WebMethod
    void loadBinaryData(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void saveBinaryData(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void loadJsonDataFasterXml(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void saveJsonDataFasterXml(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void loadJsonDataJaxb(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void saveJsonDataJaxb(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void loadXmlDataFasterXml(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void saveXmlDataFasterXml(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void loadXmlDataJaxb(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    void saveXmlDataJaxb(@NotNull final String sessionToken) throws Exception;

    @NotNull
    @WebMethod
    Domain load() throws Exception;

    @WebMethod
    void save(@NotNull final Domain domain) throws Exception;

}
