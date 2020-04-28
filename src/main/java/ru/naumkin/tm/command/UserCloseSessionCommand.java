package ru.naumkin.tm.command;

public class UserCloseSessionCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "session-close";
    }

    @Override
    public String getDescription() {
        return "Close current user session.";
    }

    @Override
    public void execute() throws Exception {

    }

}
