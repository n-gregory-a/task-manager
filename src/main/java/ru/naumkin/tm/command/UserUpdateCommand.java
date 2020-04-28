package ru.naumkin.tm.command;

public class UserUpdateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-update";
    }

    @Override
    public String getDescription() {
        return "Update user profile.";
    }

    @Override
    public void execute() throws Exception {

    }

}
