package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

public interface IDomainService {

    void loadBinaryData() throws IOException, ClassNotFoundException, SQLException;

    void saveBinaryData() throws IOException, SQLException;

    void loadJsonDataFasterXml() throws IOException, SQLException;

    void saveJsonDataFasterXml() throws IOException, SQLException;

    void loadJsonDataJaxb() throws IOException, JAXBException, SQLException;

    void saveJsonDataJaxb() throws IOException, SQLException, JAXBException;

    void loadXmlDataFasterXml() throws IOException, SQLException;

    void saveXmlDataFasterXml() throws IOException, SQLException;

    void loadXmlDataJaxb() throws IOException, JAXBException, SQLException;

    void saveXmlDataJaxb() throws IOException, SQLException, JAXBException;

    @NotNull
    Domain load() throws SQLException;

    void save(@NotNull final Domain domain) throws SQLException;

}
