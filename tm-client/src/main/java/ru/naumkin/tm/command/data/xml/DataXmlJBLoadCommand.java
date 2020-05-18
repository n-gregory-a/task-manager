package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

public class DataXmlJBLoadCommand extends AbstractCommand {

    public DataXmlJBLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-jb-xml-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from xml file by JAXB.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[LOAD DATA FROM XML FILE BY JAXB]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.loadXmlDataJaxb();
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
