package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.api.endpoint.UserDTO;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.HashGenerator;

public final class UserChangePasswordCommand extends AbstractCommand {

    public UserChangePasswordCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "password-change";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "User password change.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PASSWORD CHANGE]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = bootstrap.getTerminalService().readLine();
        @NotNull final UserDTO user =
                bootstrap.getUserEndpoint().findOneUser(login);
        bootstrap.getTerminalService().showMessage("Enter new password:");
        @NotNull final String password = bootstrap.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
