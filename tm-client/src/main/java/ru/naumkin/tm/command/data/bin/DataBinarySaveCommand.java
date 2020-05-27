package ru.naumkin.tm.command.data.bin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

public class DataBinarySaveCommand extends AbstractCommand {

    public DataBinarySaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-bin-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to binary file.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[SAVE DATA TO BINARY FILE]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.saveBinaryData(bootstrap.getCurrentSessionToken());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
