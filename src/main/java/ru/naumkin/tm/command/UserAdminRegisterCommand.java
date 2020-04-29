package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

import java.io.IOException;

public class UserAdminRegisterCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-new-admin";
    }

    @Override
    public String getDescription() {
        return "Register new administrator.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[REGISTER NEW ADMINISTRATOR]");
        User user = createUniqueLoginUser();
        bootstrap.getView().showMessage("Enter password");
        String password = bootstrap.getView().readLine();
        user.setPassword(HashGenerator.getHash(password));
        user.setRole(RoleType.ADMINISTRATOR);
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
        user.setLogin(login);
        return user;
    }

}
