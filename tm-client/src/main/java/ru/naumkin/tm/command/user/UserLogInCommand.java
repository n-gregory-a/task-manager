package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;
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
        bootstrap.getTerminalService().showMessage("[USER AUTHORISATION]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        @NotNull final String userName = bootstrap.getTerminalService().readLine();
        @NotNull final User user =
                bootstrap.getUserEndpoint().findOneUser(bootstrap.getCurrentSession(), userName);
        bootstrap.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = bootstrap.getTerminalService().readLine();
        final boolean passwordIsCorrect = HashGenerator.getHash(password).equals(user.getPassword());
        if (!passwordIsCorrect) {
            bootstrap.getTerminalService()
                    .showMessage("Password is incorrect. Authorisation failed.");
            return;
        }
        bootstrap.getUserEndpoint().setCurrentUser(bootstrap.getCurrentSession(), user);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
