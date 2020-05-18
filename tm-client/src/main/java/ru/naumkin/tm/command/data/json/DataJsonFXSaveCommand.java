package ru.naumkin.tm.command.data.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

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
        return "Save data to json file by FasterXML.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[SAVE DATA TO JSON FILE BY FASTERXML]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.saveJsonDataFasterXml();
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
