package ru.naumkin.tm;

import ru.naumkin.tm.context.Bootstrap;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}