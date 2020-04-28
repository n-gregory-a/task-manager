package ru.naumkin.tm.command;

public class UserReadCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-read";
    }

    @Override
    public String getDescription() {
        return "Show user profile.";
    }

    @Override
    public void execute() throws Exception {

    }

}
