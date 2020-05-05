package ru.naumkin.tm.view;

import java.io.BufferedReader;
import java.io.IOException;

public final class TerminalService {

    private final BufferedReader reader;

    public TerminalService(BufferedReader reader) {
        this.reader = reader;
    }

    public void showMessage(final String message) {
        System.out.println(message);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

}
