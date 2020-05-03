package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.UserIsNullException;

public class UserUpdateCommand extends AbstractCommand {

    public UserUpdateCommand() {
        super(true);
    }

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
        bootstrap.getView().showMessage("Enter login:");
        String login = bootstrap.getView().readLine();
        User user = bootstrap.getUserService().findOne(login);
        bootstrap.getView().showMessage("Enter new login:");
        String newLogin = bootstrap.getView().readLine();
        user.setName(newLogin);
        try {
            bootstrap.getUserService().merge(user, login);
        } catch (NameIsNullException | NameIsEmptyException | UserIsNullException e) {
            bootstrap.getView().showMessage(e.toString());
            return;
        }
        bootstrap.getView().showMessage("[OK]");
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
