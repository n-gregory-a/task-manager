package ru.naumkin.tm;

import ru.naumkin.tm.context.Bootstrap;

public final class Application {

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}
