package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.NoUserWithSuchLoginException;
import ru.naumkin.tm.util.HashGenerator;

import java.io.IOException;

public class UserLogInCommand extends AbstractCommand {

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
        bootstrap.getTerminalService().showMessage("[USER AUTHORISATION]");
        User user = getUserByName();
        bootstrap.getTerminalService().showMessage("Enter password:");
        String password = bootstrap.getTerminalService().readLine();
        boolean passwordIsCorrect = HashGenerator.getHash(password).equals(user.getPassword());
        if (!passwordIsCorrect) {
            bootstrap.getTerminalService().showMessage("Password is incorrect. Authorisation failed.");
            return;
        }
        bootstrap.setCurrentUser(user);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    private User getUserByName() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter login:");
        User user;
        try {
            user = bootstrap.getUserService().findOne(bootstrap.getTerminalService().readLine());
        } catch (NameIsNullException | NameIsEmptyException | NoUserWithSuchLoginException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            user = getUserByName();
        }
        return user;
    }

}
