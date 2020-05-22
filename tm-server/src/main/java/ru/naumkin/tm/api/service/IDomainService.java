package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.Domain;

import java.sql.SQLException;

public interface IDomainService {

    void loadBinaryData() throws Exception;

    void saveBinaryData() throws Exception;

    void loadJsonDataFasterXml() throws Exception;

    void saveJsonDataFasterXml() throws Exception;

    void loadJsonDataJaxb() throws Exception;

    void saveJsonDataJaxb() throws Exception;

    void loadXmlDataFasterXml() throws Exception;

    void saveXmlDataFasterXml() throws Exception;

    void loadXmlDataJaxb() throws Exception;

    void saveXmlDataJaxb() throws Exception;

    @NotNull
    Domain load() throws SQLException;

    void save(@NotNull final Domain domain) throws SQLException;

}
