package ru.naumkin.tm.command.data.bin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;

public class DataBinaryLoadCommand extends AbstractCommand {

    public DataBinaryLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-bin-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from binary file.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[LOAD DATA FROM BINARY FILE]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.loadBinaryData(bootstrap.getCurrentSession());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
