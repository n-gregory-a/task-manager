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
        serviceLocator.getTerminalService().showMessage("[USER UPDATE PROFILE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        String login = serviceLocator.getTerminalService().readLine();
        User user = serviceLocator.getUserService().findOne(login);
        serviceLocator.getTerminalService().showMessage("Enter new login:");
        String newLogin = serviceLocator.getTerminalService().readLine();
        user.setName(newLogin);
        try {
            serviceLocator.getUserService().merge(user, login);
        } catch (NameIsNullException | NameIsEmptyException | UserIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
