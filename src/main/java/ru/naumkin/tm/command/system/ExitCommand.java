package ru.naumkin.tm.command.system;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

public final class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super(false);
    }

    @NotNull
    @Override
    public String getName() {
        return "exit";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Close program.";
    }

    @Override
    public void execute() {
        System.exit(1);
    }

}
