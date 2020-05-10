package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.context.Bootstrap;

import java.util.Set;

public final class Application {

    public static void main(String[] args) throws Exception {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        final Set<Class<? extends AbstractCommand>> classes =
                new Reflections("ru.naumkin.tm").getSubTypesOf(AbstractCommand.class);
        bootstrap.init(classes);
    }

}
