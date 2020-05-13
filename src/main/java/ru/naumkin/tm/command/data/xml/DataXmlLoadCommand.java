package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DataXmlLoadCommand extends AbstractCommand {

    public DataXmlLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-jb-xml-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from xml file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[LOAD DATA FROM XML FILE]");
        @NotNull final File file = new File(DataConstant.XML_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream =
                new ObjectInputStream(fileInputStream);
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Unmarshaller unmarshaller = context.createUnmarshaller();
        @NotNull final Domain domain = (Domain) unmarshaller.unmarshal(objectInputStream);
        objectInputStream.close();
        serviceLocator.getDomainService().save(serviceLocator, domain);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
