package ru.naumkin.tm.command.system;

import ru.naumkin.tm.command.AbstractCommand;

public final class ExitCommand extends AbstractCommand {

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
    public void execute() {
        System.exit(1);
    }

}
