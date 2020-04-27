package ru.naumkin.tm.view;

import java.io.BufferedReader;
import java.io.IOException;

public class View {

    private BufferedReader reader;

    public View(BufferedReader reader) {
        this.reader = reader;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

}
