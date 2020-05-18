package ru.naumkin.tm.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

import java.io.IOException;
import java.util.List;

public interface ITerminalService {

    void showMessage(@NotNull final String message);

    @NotNull
    String readLine() throws IOException;

    @NotNull
    List<AbstractCommand> getCommand();

    void printEntity(@NotNull final Object object) throws JsonProcessingException;

}
