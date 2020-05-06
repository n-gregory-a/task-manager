package ru.naumkin.tm.view;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;

public final class TerminalService {

    @NotNull private final BufferedReader reader;

    public TerminalService(@NotNull BufferedReader reader) {
        this.reader = reader;
    }

    public void showMessage(@Nullable final String message) {
        System.out.println(message);
    }

    @NotNull
    public String readLine() throws IOException {
        return reader.readLine();
    }

}
