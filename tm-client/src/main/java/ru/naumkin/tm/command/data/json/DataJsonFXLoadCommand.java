package ru.naumkin.tm.command.data.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[LOAD DATA FROM JSON FILE BY FASTERXML]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.loadJsonDataFasterXml(bootstrap.getCurrentSession());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
