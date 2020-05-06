package ru.naumkin.tm.view;

import ru.naumkin.tm.command.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class TerminalService {

    private final BufferedReader reader;

    private final Map<String, AbstractCommand> commands;

    public TerminalService(BufferedReader reader, Map<String, AbstractCommand> commands) {
        this.reader = reader;
        this.commands = commands;
    }

    public void showMessage(final String message) {
        System.out.println(message);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public List<AbstractCommand> getCommand() {
        return new ArrayList<>(commands.values());
    }


}
