package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IDomainEndpoint {

    @WebMethod
    void loadBinaryData(@NotNull final Session session) throws Exception;

    @WebMethod
    void saveBinaryData(@NotNull final Session session) throws Exception;

    @WebMethod
    void loadJsonDataFasterXml(@NotNull final Session session) throws Exception;

    @WebMethod
    void saveJsonDataFasterXml(@NotNull final Session session) throws Exception;

    @WebMethod
    void loadJsonDataJaxb(@NotNull final Session session) throws Exception;

    @WebMethod
    void saveJsonDataJaxb(@NotNull final Session session) throws Exception;

    @WebMethod
    void loadXmlDataFasterXml(@NotNull final Session session) throws Exception;

    @WebMethod
    void saveXmlDataFasterXml(@NotNull final Session session) throws Exception;

    @WebMethod
    void loadXmlDataJaxb(@NotNull final Session session) throws Exception;

    @WebMethod
    void saveXmlDataJaxb(@NotNull final Session session) throws Exception;

    @NotNull
    @WebMethod
    Domain load();

    @WebMethod
    void save(@NotNull final Domain domain);

}
