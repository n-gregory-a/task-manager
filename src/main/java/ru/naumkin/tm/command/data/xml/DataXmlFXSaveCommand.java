package ru.naumkin.tm.command.data.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;

import java.io.File;
import java.nio.file.Files;

public class DataXmlFXSaveCommand extends AbstractCommand {

    public DataXmlFXSaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-xml-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to xml file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[SAVE DATA TO XML FILE]");
        @NotNull final IDomainService domainService = serviceLocator.getDomainService();
        @NotNull final Domain domain = domainService.load(serviceLocator);
        @NotNull final File file = new File(DataConstant.XML_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
