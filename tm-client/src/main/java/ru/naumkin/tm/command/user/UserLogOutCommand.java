package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

import java.sql.SQLException;

public final class UserLogOutCommand extends AbstractCommand {

    public UserLogOutCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "log-out";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Close current user session.";
    }

    @Override
    public void execute() throws SQLException {
        bootstrap.getTerminalService().showMessage("[USER CLOSE SESSION]");
        bootstrap.getSessionEndpoint().close(bootstrap.getCurrentSession());
        bootstrap.getTerminalService().showMessage("Session was closed.");
    }

}
