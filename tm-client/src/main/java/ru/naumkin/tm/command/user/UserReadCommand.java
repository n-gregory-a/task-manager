package ru.naumkin.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;

public final class UserReadCommand extends AbstractCommand {

    public UserReadCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "user-read";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show user profile.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[READ USER PROFILE]");
        bootstrap.getTerminalService().showMessage("Enter login:");
        @NotNull final String login = bootstrap.getTerminalService().readLine();
        @NotNull final User user = bootstrap.getUserEndpoint().findOneUser(login);
        bootstrap.getTerminalService().printEntity(user);
    }

    @NotNull
    @Override
    public RoleType[] getRoles() {
        return new RoleType[] {RoleType.ADMINISTRATOR};
    }

}
