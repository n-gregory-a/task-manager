package ru.naumkin.tm.command.system;

import ru.naumkin.tm.command.AbstractCommand;

public class HelpCommand  extends AbstractCommand {

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
    public void execute() throws Exception {
        for (final AbstractCommand command: serviceLocator.getCommand()) {
            serviceLocator.getTerminalService().showMessage(command.getName() + ": " + command.getDescription());
        }
    }

}
