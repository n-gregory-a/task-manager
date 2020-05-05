package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public class UserReadCommand extends AbstractCommand {

    public UserReadCommand() {
        super(true);
    }

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
        serviceLocator.getTerminalService().showMessage("[READ USER PROFILE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        String login = serviceLocator.getTerminalService().readLine();
        User user;
        try {
            user = serviceLocator.getUserService().findOne(login);
        } catch (RuntimeException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        serviceLocator.getTerminalService().showMessage(user.toString());
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
