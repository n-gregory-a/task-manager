package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;
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
        bootstrap.getTerminalService().showMessage("[REGISTER NEW USER]");
        @NotNull final User user = createUniqueLoginUser();
        bootstrap.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = bootstrap.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        bootstrap.getUserEndpoint().persistUser(bootstrap.getCurrentSession(), user);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    private User createUniqueLoginUser() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = bootstrap.getTerminalService().readLine();
        User user = new User();
        user.setName(login);
        for (@NotNull final User u:
                bootstrap.getUserEndpoint().findAllUsers(bootstrap.getCurrentSession())
        ) {
            if (u.getName().equals(login)) {
                bootstrap.getTerminalService().showMessage("The login is occupied.");
                createUniqueLoginUser();
            }
        }
        return user;
    }

}
