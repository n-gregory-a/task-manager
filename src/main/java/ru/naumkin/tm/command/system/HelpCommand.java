package ru.naumkin.tm.command.system;

import ru.naumkin.tm.command.AbstractCommand;

public final class HelpCommand  extends AbstractCommand {

    public HelpCommand() {
        super(false);
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (final AbstractCommand command: serviceLocator.getCommand()) {
            serviceLocator.getTerminalService().showMessage(command.getName() + ": " + command.getDescription());
        }
    }

}
