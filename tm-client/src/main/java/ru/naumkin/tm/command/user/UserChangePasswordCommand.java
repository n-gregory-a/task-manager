package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
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
        serviceLocator.getTerminalService().showMessage("[PASSWORD CHANGE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = serviceLocator.getTerminalService().readLine();
        @NotNull final User user = serviceLocator.getUserService().findOne(login);
        serviceLocator.getTerminalService().showMessage("Enter new password:");
        @NotNull final String password = serviceLocator.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
