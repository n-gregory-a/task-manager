package ru.naumkin.tm.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.enumerated.RoleType;

import java.io.File;

public class DataJsonFXLoadCommand extends AbstractCommand {

    public DataJsonFXLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-json-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from json file by FasterXML.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[LOAD DATA FROM JSON FILE BY FASTERXML]");
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
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
