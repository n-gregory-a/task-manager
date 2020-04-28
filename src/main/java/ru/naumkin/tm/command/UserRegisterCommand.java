package ru.naumkin.tm.command;

public class UserRegisterCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-new";
    }

    @Override
    public String getDescription() {
        return "Register new user.";
    }

    @Override
    public void execute() throws Exception {

    }

}
