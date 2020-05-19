package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IDomainEndpoint {

    @WebMethod
    void loadBinaryData(@Nullable final Session session) throws Exception;

    @WebMethod
    void saveBinaryData(@Nullable final Session session) throws Exception;

    @WebMethod
    void loadJsonDataFasterXml(@Nullable final Session session) throws Exception;

    @WebMethod
    void saveJsonDataFasterXml(@Nullable final Session session) throws Exception;

    @WebMethod
    void loadJsonDataJaxb(@Nullable final Session session) throws Exception;

    @WebMethod
    void saveJsonDataJaxb(@Nullable final Session session) throws Exception;

    @WebMethod
    void loadXmlDataFasterXml(@Nullable final Session session) throws Exception;

    @WebMethod
    void saveXmlDataFasterXml(@Nullable final Session session) throws Exception;

    @WebMethod
    void loadXmlDataJaxb(@Nullable final Session session) throws Exception;

    @WebMethod
    void saveXmlDataJaxb(@Nullable final Session session) throws Exception;

    @NotNull
    @WebMethod
    Domain load();

    @WebMethod
    void save(@NotNull final Domain domain);

}
