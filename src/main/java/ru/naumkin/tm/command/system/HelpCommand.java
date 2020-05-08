package ru.naumkin.tm.command.system;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

public final class HelpCommand  extends AbstractCommand {

    public HelpCommand() {
        super(false);
    }

    @NotNull
    @Override
    public String getName() {
        return "help";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (@NotNull final AbstractCommand command: serviceLocator.getTerminalService().getCommand()) {
            serviceLocator.getTerminalService().showMessage(command.getName() + ": " + command.getDescription());
        }
    }

}
