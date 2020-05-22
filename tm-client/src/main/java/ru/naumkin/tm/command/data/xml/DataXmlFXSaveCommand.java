package ru.naumkin.tm.command.data.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;

public class DataXmlFXSaveCommand extends AbstractCommand {

    public DataXmlFXSaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-fx-xml-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to xml file by FasterXML.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[SAVE DATA TO XML FILE BY FASTERXML]");
        @NotNull final IDomainEndpoint domainEndpoint = bootstrap.getDomainEndpoint();
        domainEndpoint.saveXmlDataFasterXml(bootstrap.getCurrentSession());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
