package ru.naumkin.tm.command;

public class ExitCommand extends AbstractCommand {

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
