package ru.naumkin.tm.command.data.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.enumerated.RoleType;

import java.io.File;

public class DataXmlFXLoadCommand extends AbstractCommand {

    public DataXmlFXLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-xml-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from xml file by FasterXML.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[LOAD DATA FROM XML FILE BY FASTERXML]");
        @NotNull final File file = new File(DataConstant.XML_FILE);
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        @NotNull final Domain domain = objectMapper.readValue(file, Domain.class);
        serviceLocator.getDomainService().save(serviceLocator, domain);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
