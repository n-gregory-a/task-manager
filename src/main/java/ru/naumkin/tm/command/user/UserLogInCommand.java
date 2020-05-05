package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.NoUserWithSuchLoginException;
import ru.naumkin.tm.util.HashGenerator;

import java.io.IOException;

public final class UserLogInCommand extends AbstractCommand {

    public UserLogInCommand() {
        super(false);
    }

    @Override
    public String getName() {
        return "log-in";
    }

    @Override
    public String getDescription() {
        return "Authorise user.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[USER AUTHORISATION]");
        User user = getUserByName();
        serviceLocator.getTerminalService().showMessage("Enter password:");
        final String password = serviceLocator.getTerminalService().readLine();
        final boolean passwordIsCorrect = HashGenerator.getHash(password).equals(user.getPassword());
        if (!passwordIsCorrect) {
            serviceLocator.getTerminalService().showMessage("Password is incorrect. Authorisation failed.");
            return;
        }
        serviceLocator.setCurrentUser(user);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    private User getUserByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter login:");
        User user;
        try {
            user = serviceLocator.getUserService().findOne(serviceLocator.getTerminalService().readLine());
        } catch (NameIsNullException | NameIsEmptyException | NoUserWithSuchLoginException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            user = getUserByName();
        }
        return user;
    }

}
