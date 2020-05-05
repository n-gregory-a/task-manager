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
        bootstrap.getTerminalService().showMessage("[READ USER PROFILE]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        String login = bootstrap.getTerminalService().readLine();
        User user;
        try {
            user = bootstrap.getUserService().findOne(login);
        } catch (RuntimeException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            return;
        }
        bootstrap.getTerminalService().showMessage(user.toString());
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
