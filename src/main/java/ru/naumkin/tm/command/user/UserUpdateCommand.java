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
        bootstrap.getTerminalService().showMessage("[USER UPDATE PROFILE]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        String login = bootstrap.getTerminalService().readLine();
        User user = bootstrap.getUserService().findOne(login);
        bootstrap.getTerminalService().showMessage("Enter new login:");
        String newLogin = bootstrap.getTerminalService().readLine();
        user.setName(newLogin);
        try {
            bootstrap.getUserService().merge(user, login);
        } catch (NameIsNullException | NameIsEmptyException | UserIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            return;
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
