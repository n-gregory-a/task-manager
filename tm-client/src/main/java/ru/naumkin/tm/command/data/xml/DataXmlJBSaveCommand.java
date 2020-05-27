package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

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
        return "Save data to xml file by JAXB.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[SAVE DATA TO XML FILE BY JAXB]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.saveXmlDataJaxb(bootstrap.getCurrentSessionToken());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
