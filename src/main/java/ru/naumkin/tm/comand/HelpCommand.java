package ru.naumkin.tm.comand;

public class HelpCommand  extends AbstractCommand {

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
        for (final AbstractCommand command: bootstrap.getCommands()) {
            bootstrap.getView().showMessage(command.getName() + ": " + command.getDescription());
        }
    }

}
