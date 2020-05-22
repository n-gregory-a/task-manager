package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

@WebService
public interface IDomainEndpoint {

    @WebMethod
    void loadBinaryData(@NotNull final Session session) throws IOException, ClassNotFoundException, SQLException;

    @WebMethod
    void saveBinaryData(@NotNull final Session session) throws IOException, SQLException;

    @WebMethod
    void loadJsonDataFasterXml(@NotNull final Session session) throws IOException, SQLException;

    @WebMethod
    void saveJsonDataFasterXml(@NotNull final Session session) throws IOException, SQLException;

    @WebMethod
    void loadJsonDataJaxb(@NotNull final Session session) throws IOException, JAXBException, SQLException;

    @WebMethod
    void saveJsonDataJaxb(@NotNull final Session session) throws IOException, SQLException, JAXBException;

    @WebMethod
    void loadXmlDataFasterXml(@NotNull final Session session) throws IOException, SQLException;

    @WebMethod
    void saveXmlDataFasterXml(@NotNull final Session session) throws IOException, SQLException;

    @WebMethod
    void loadXmlDataJaxb(@NotNull final Session session) throws IOException, JAXBException, SQLException;

    @WebMethod
    void saveXmlDataJaxb(@NotNull final Session session) throws IOException, SQLException, JAXBException;

    @NotNull
    @WebMethod
    Domain load() throws SQLException;

    @WebMethod
    void save(@NotNull final Domain domain) throws SQLException;

}
