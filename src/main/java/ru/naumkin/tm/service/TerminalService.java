package ru.naumkin.tm.service;

import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.command.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class TerminalService implements ITerminalService {

    private final BufferedReader reader;

    private final Map<String, AbstractCommand> commands;

    public TerminalService(BufferedReader reader, Map<String, AbstractCommand> commands) {
        this.reader = reader;
        this.commands = commands;
    }

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public List<AbstractCommand> getCommand() {
        return new ArrayList<>(commands.values());
    }

}