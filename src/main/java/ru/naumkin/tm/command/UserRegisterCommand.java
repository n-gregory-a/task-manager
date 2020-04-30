package ru.naumkin.tm.command;

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
        bootstrap.getView().showMessage("[REGISTER NEW USER]");
        User user = createUniqueLoginUser();
        bootstrap.getView().showMessage("Enter password:");
        String password = bootstrap.getView().readLine();
        user.setPassword(HashGenerator.getHash(password));
        try {
            bootstrap.getUserService().persist(user);
        } catch (UserIsNullException e) {
            bootstrap.getView().showMessage(e.toString());;
        }
        bootstrap.getView().showMessage("[OK]");
    }

    private User createUniqueLoginUser() throws IOException {
        bootstrap.getView().showMessage("Enter login:");
        String login = bootstrap.getView().readLine();
        User user = new User();
        user.setLogin(login);
        for (User u: bootstrap.getUserService().findAll()) {
            if (u.getLogin().equals(login)) {
                bootstrap.getView().showMessage("The login is occupied.");
                createUniqueLoginUser();
            }
        }
        return user;
    }

}
