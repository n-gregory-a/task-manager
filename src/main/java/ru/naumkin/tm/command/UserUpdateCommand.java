package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.User;

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
        bootstrap.getView().showMessage("[USER UPDATE PROFILE]");
        User user = bootstrap.getCurrentUser();
        String login = user.getLogin();
        bootstrap.getView().showMessage("Enter new login:");
        String newLogin = bootstrap.getView().readLine();
        user.setLogin(newLogin);
        try {
            bootstrap.getUserService().merge(user, login);
        } catch (IllegalArgumentException | NullPointerException e) {
            bootstrap.getView().showMessage(e.getMessage());
            return;
        }
        bootstrap.getView().showMessage("[OK]");
    }

}
