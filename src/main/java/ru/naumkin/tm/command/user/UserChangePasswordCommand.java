package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

public class UserChangePasswordCommand extends AbstractCommand {

    public UserChangePasswordCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "password-change";
    }

    @Override
    public String getDescription() {
        return "User password change.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[PASSWORD CHANGE]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        String login = serviceLocator.getTerminalService().readLine();
        User user = serviceLocator.getUserService().findOne(login);
        serviceLocator.getTerminalService().showMessage("Enter new password:");
        String password = serviceLocator.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
