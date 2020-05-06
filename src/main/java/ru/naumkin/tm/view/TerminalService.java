package ru.naumkin.tm.view;

import ru.naumkin.tm.command.AbstractCommand;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class TerminalService {

    @NotNull private final BufferedReader reader;

    private final Map<String, AbstractCommand> commands;

    public TerminalService(BufferedReader reader, Map<String, AbstractCommand> commands) {
    public TerminalService(@NotNull BufferedReader reader) {
        this.reader = reader;
        this.commands = commands;
    }

    public void showMessage(@Nullable final String message) {
        System.out.println(message);
    }

    @NotNull
    public String readLine() throws IOException {
        return reader.readLine();
    }

    public List<AbstractCommand> getCommand() {
        return new ArrayList<>(commands.values());
    }

}
