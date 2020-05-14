package ru.naumkin.tm.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;

import java.io.File;
import java.nio.file.Files;

public class DataJsonFXSaveCommand extends AbstractCommand {

    public DataJsonFXSaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-json-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to json file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[SAVE DATA TO JSON FILE]");
        @NotNull final IDomainService domainService = serviceLocator.getDomainService();
        @NotNull final Domain domain = domainService.load(serviceLocator);
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }
}
