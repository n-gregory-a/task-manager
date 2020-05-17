package ru.naumkin.tm.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.enpoint.ProjectEndpointService;
import ru.naumkin.tm.enpoint.TaskEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;
import ru.naumkin.tm.service.TerminalService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public final class Bootstrap {


    @NotNull
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @NotNull
    private final  Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    @Getter
    @NotNull
    private final ITerminalService terminalService = new TerminalService(reader, commands);

    @Getter
    @NotNull
    private final IProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    @Getter
    @NotNull
    private final ITaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    @Getter
    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    public void registerCommand(@NotNull final AbstractCommand command) {
        @Nullable final String cliCommand = command.getName();
        @Nullable final String cliDescription = command.getDescription();
        if (cliCommand == null || cliCommand.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (cliDescription == null || cliDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        command.setBootstrap(this);
        commands.put(cliCommand, command);
    }

    public void init(@NotNull final Set<Class<? extends AbstractCommand>> classes) throws Exception {
        terminalService.showMessage("*** Welcome to task manager ***");
        createDefaultUser();
        @NotNull final Class abstractCommand = AbstractCommand.class;
        for (@NotNull final Class clazz: classes) {
            if (abstractCommand.isAssignableFrom(clazz)) {
                @NotNull final AbstractCommand command = (AbstractCommand) clazz.newInstance();
                registerCommand(command);
            }
        }
        @Nullable String command;
        while (true) {
            command = terminalService.readLine();
            try {
                execute(command);
            } catch (Exception e) {
                terminalService.showMessage("Something went wrong. Please try again.");
            }
        }
    }

    private void execute(@Nullable final String command) throws Exception {
        if (command == null || command.isEmpty()) {
            return;
        }
        @Nullable final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) {
            getTerminalService().showMessage("Unknown command");
            return;
        }
        final boolean secureCheck = !abstractCommand.isSecure() ||
                (abstractCommand.isSecure() && userEndpoint.getCurrentUser() != null);
        final boolean roleCheck = (abstractCommand.getRoles() == null) ||
                (abstractCommand.getRoles() != null &&
                        userEndpoint.isRoleAdmin(userEndpoint.getCurrentUser()));
        if (secureCheck && roleCheck) {
            abstractCommand.execute();
            return;
        }
        getTerminalService().showMessage("This command is not allowed.");
    }

    public void createDefaultUser() {
        User user = userEndpoint.createUser(RoleType.USER);
        User administrator = userEndpoint.createUser(RoleType.ADMINISTRATOR);
        userEndpoint.setCurrentUser(user);
    }

}
