package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class DataXmlJBSaveCommand extends AbstractCommand {

    public DataXmlJBSaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-jb-xml-save";
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
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(domain, objectOutputStream);
        objectOutputStream.close();
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
