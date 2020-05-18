package ru.naumkin.tm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.command.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public final class TerminalService implements ITerminalService {

    @NotNull
    private BufferedReader reader;

    @NotNull
    private Map<String, AbstractCommand> commands;

    public TerminalService(
            @NotNull final BufferedReader reader,
            @NotNull final Map<String, AbstractCommand> commands
    ) {
        this.reader = reader;
        this.commands = commands;
    }

    @Override
    public void showMessage(@Nullable final String message) {
        System.out.println(message);
    }

    @NotNull
    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }

    @NotNull
    @Override
    public List<AbstractCommand> getCommand() {
        return new ArrayList<>(commands.values());
    }

    @Override
    public void printEntity(@NotNull Object object) throws JsonProcessingException {
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        showMessage(json);
    }
}
