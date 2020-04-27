package ru.naumkin.tm.command;

import ru.naumkin.tm.context.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute() throws Exception;

}
