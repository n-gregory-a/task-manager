package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.util.HashGenerator;

public final class UserLogInCommand extends AbstractCommand {

    public UserLogInCommand() {
        super(false);
    }

    @NotNull
    @Override
    public String getName() {
        return "log-in";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Authorise user.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[USER AUTHORISATION]");
        serviceLocator.getTerminalService().showMessage("Enter login:");
        @NotNull final String userName = serviceLocator.getTerminalService().readLine();
        @NotNull final User user = serviceLocator.getUserService().findOne(userName);
        serviceLocator.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = serviceLocator.getTerminalService().readLine();
        final boolean passwordIsCorrect = HashGenerator.getHash(password).equals(user.getPassword());
        if (!passwordIsCorrect) {
            serviceLocator.getTerminalService()
                    .showMessage("Password is incorrect. Authorisation failed.");
            return;
        }
        serviceLocator.getUserService().setCurrentUser(user);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
