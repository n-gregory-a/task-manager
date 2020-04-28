package ru.naumkin.tm.command;

public class UserChangePasswordCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "password-change";
    }

    @Override
    public String getDescription() {
        return "User password change.";
    }

    @Override
    public void execute() throws Exception {

    }

}
