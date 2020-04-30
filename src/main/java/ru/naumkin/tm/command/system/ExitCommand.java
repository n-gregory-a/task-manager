package ru.naumkin.tm.command.system;

import ru.naumkin.tm.command.AbstractCommand;

public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super(false);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Close program.";
    }

    @Override
    public void execute() throws Exception {
        System.exit(1);
    }

}
