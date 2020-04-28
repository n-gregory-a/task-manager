package ru.naumkin.tm.command;

public class UserAuthoriseCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "log-in";
    }

    @Override
    public String getDescription() {
        return "Authorise user.";
    }

    @Override
    public void execute() throws Exception {

    }

}
