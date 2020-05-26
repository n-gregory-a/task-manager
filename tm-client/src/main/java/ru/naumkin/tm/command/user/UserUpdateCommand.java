package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[USER UPDATE PROFILE]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        @Nullable final String login = bootstrap.getTerminalService().readLine();
        @NotNull final User user =
                bootstrap.getUserEndpoint().findOneUser(login);
        bootstrap.getTerminalService().showMessage("Enter new login:");
        @NotNull final String newLogin = bootstrap.getTerminalService().readLine();
        user.setName(newLogin);
        bootstrap.getUserEndpoint().mergeUser(bootstrap.getCurrentSession(), user);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
