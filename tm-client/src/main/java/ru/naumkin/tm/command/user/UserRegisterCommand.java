package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.UserDTO;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.HashGenerator;

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
        @NotNull final UserDTO user = createUniqueLoginUser();
        bootstrap.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = bootstrap.getTerminalService().readLine();
        user.setPassword(HashGenerator.getHash(password));
        bootstrap.getUserEndpoint().persistUser(user);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    @NotNull
    private UserDTO createUniqueLoginUser() throws Exception {
        bootstrap.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = bootstrap.getTerminalService().readLine();
        UserDTO user = new UserDTO();
        user.setName(login);
        for (@NotNull final UserDTO u:
                bootstrap.getUserEndpoint().findAllUsers()
        ) {
            if (u.getName().equals(login)) {
                bootstrap.getTerminalService().showMessage("The login is occupied.");
                createUniqueLoginUser();
            }
        }
        return user;
    }

}
