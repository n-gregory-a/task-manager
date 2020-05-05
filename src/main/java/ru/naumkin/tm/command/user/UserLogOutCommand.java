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
        serviceLocator.getTerminalService().showMessage("[USER CLOSE SESSION]");
        serviceLocator.setCurrentUser(null);
        serviceLocator.getTerminalService().showMessage("Session was closed.");
    }

}
