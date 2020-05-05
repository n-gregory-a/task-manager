package ru.naumkin.tm.command.user;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.UserIsNullException;
import ru.naumkin.tm.util.HashGenerator;

import java.io.IOException;

public class UserRegisterCommand extends AbstractCommand {

    public UserRegisterCommand() {
        super(false);
    }

    @Override
    public String getName() {
        return "user-new";
    }

    @Override
    public String getDescription() {
        return "Register new user.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[REGISTER NEW USER]");
        User user = createUniqueLoginUser();
        bootstrap.getTerminalService().showMessage("Enter password:");
        String password = bootstrap.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        try {
            bootstrap.getUserService().persist(user);
        } catch (UserIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());;
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    private User createUniqueLoginUser() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter login:");
        String login = bootstrap.getTerminalService().readLine();
        User user = new User();
        user.setName(login);
        for (User u: bootstrap.getUserService().findAll()) {
            if (u.getName().equals(login)) {
                bootstrap.getTerminalService().showMessage("The login is occupied.");
                createUniqueLoginUser();
            }
        }
        return user;
    }

}
