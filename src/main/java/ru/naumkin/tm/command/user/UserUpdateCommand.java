package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;

public final class UserUpdateCommand extends AbstractCommand {

    public UserUpdateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "user-update";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Update user profile.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[USER UPDATE PROFILE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        @Nullable final String login = serviceLocator.getTerminalService().readLine();
        @NotNull final User user = serviceLocator.getUserService().findOne(login);
        serviceLocator.getTerminalService().showMessage("Enter new login:");
        @NotNull final String newLogin = serviceLocator.getTerminalService().readLine();
        user.setName(newLogin);
        serviceLocator.getUserService().merge(user, login);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
