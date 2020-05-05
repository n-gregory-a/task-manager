package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;

public class UserLogOutCommand extends AbstractCommand {

    public UserLogOutCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "log-out";
    }

    @Override
    public String getDescription() {
        return "Close current user session.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[USER CLOSE SESSION]");
        bootstrap.setCurrentUser(null);
        bootstrap.getTerminalService().showMessage("Session was closed.");
    }

}
