package ru.naumkin.tm.command.data.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

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
        return "Save data to json file by JAXB.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[SAVE DATA TO JSON FILE BY JAXB]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.saveJsonDataJaxb(bootstrap.getCurrentSessionToken());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
