package ru.naumkin.tm.command.data.json;

import org.eclipse.persistence.jaxb.MarshallerProperties;
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

public class DataJsonJBSaveCommand extends AbstractCommand {

    public DataJsonJBSaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-jb-json-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to json file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[SAVE DATA TO JSON FILE BY JAXB]");
        @NotNull final IDomainService domainService = serviceLocator.getDomainService();
        @NotNull final Domain domain = domainService.load(serviceLocator);
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
        marshaller.marshal(domain, objectOutputStream);
        objectOutputStream.close();
        serviceLocator.getTerminalService().showMessage("[OK]");
    }
}
