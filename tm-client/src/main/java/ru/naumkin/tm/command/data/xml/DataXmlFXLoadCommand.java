package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.command.AbstractCommand;

public class DataXmlFXLoadCommand extends AbstractCommand {

    public DataXmlFXLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-xml-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from xml file by FasterXML.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[LOAD DATA FROM XML FILE BY FASTERXML]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.loadXmlDataFasterXml();
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
