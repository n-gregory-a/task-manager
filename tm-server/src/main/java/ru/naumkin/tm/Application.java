package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.context.Bootstrap;

public final class Application {

    public static void main(String[] args) throws Exception {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
        System.out.println("Server started.");
    }

}
