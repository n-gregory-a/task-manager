package ru.naumkin.tm;

import ru.naumkin.tm.context.Bootstrap;

public class Application {

    public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}
