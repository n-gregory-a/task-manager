package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Session;
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
                bootstrap.getUserEndpoint().findOneUser(userName);
        bootstrap.getTerminalService().showMessage("Enter password:");
        @NotNull final String password = bootstrap.getTerminalService().readLine();
        final boolean passwordIsCorrect = HashGenerator.getHash(password).equals(user.getPassword());
        if (!passwordIsCorrect) {
            bootstrap.getTerminalService()
                    .showMessage("Password is incorrect. Authorisation failed.");
            return;
        }
        bootstrap.getSessionEndpoint().close(bootstrap.getCurrentSession());
        @NotNull final Session session =
                bootstrap.getSessionEndpoint().open(user.getName(), user.getPassword());
        bootstrap.setCurrentSession(session);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
