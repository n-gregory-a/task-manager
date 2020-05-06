package ru.naumkin.tm.api.service;

import ru.naumkin.tm.command.AbstractCommand;

import java.io.IOException;
import java.util.List;

public interface ITerminalService {

    void showMessage(final String message);

    String readLine() throws IOException;

    List<AbstractCommand> getCommand();

}
