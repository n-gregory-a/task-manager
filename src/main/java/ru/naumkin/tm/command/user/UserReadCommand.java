package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public final class UserReadCommand extends AbstractCommand {

    public UserReadCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "user-read";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show user profile.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[READ USER PROFILE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = serviceLocator.getTerminalService().readLine();
        @NotNull final User user = serviceLocator.getUserService().findOne(login);
        serviceLocator.getTerminalService().showMessage(user.toString());
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
