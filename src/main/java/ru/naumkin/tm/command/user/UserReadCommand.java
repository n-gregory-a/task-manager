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
        bootstrap.getView().showMessage("[READ USER PROFILE]");
        bootstrap.getView().showMessage("Enter login:");
        String login = bootstrap.getView().readLine();
        User user;
        try {
            user = bootstrap.getUserService().findOne(login);
        } catch (RuntimeException e) {
            bootstrap.getView().showMessage(e.toString());
            return;
        }
        bootstrap.getView().showMessage(user.toString());
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
