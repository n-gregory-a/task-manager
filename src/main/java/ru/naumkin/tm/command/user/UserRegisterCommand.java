package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.UserIsNullException;
import ru.naumkin.tm.util.HashGenerator;

import java.io.IOException;

public final class UserRegisterCommand extends AbstractCommand {

    public UserRegisterCommand() {
        super(false);
    }

    @NotNull
    @Override
    public String getName() {
        return "user-new";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Register new user.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[REGISTER NEW USER]");
        @NotNull final User user = createUniqueLoginUser();
        serviceLocator.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = serviceLocator.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        try {
            serviceLocator.getUserService().persist(user);
        } catch (UserIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    private User createUniqueLoginUser() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = serviceLocator.getTerminalService().readLine();
        User user = new User();
        user.setName(login);
        for (@NotNull final User u: serviceLocator.getUserService().findAll()) {
            if (u.getName().equals(login)) {
                serviceLocator.getTerminalService().showMessage("The login is occupied.");
                createUniqueLoginUser();
            }
        }
        return user;
    }

}
