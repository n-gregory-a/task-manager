package ru.naumkin.tm.command;

public class UserLogOutCommand extends AbstractCommand {

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
        bootstrap.getView().showMessage("[USER CLOSE SESSION]");
        bootstrap.setCurrentUser(bootstrap.getUserService().findOne("user"));
        bootstrap.getView().showMessage("Session was closed.");
    }

}
