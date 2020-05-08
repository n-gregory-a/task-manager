package ru.naumkin.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;

import java.io.IOException;
import java.util.List;

public interface ITerminalService {

    void showMessage(@NotNull final String message);

    @Nullable
    String readLine() throws IOException;

    @NotNull
    List<AbstractCommand> getCommand();

}
