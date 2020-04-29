package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.User;

import java.io.IOException;

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
        bootstrap.getView().showMessage("[READ USER PROFILE]");
        User user = bootstrap.getCurrentUser();
        bootstrap.getView().showMessage(user.toString());
    }

}
