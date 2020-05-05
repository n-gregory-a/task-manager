package ru.naumkin.tm.command;

import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.context.Bootstrap;
import ru.naumkin.tm.enumerated.RoleType;

public abstract class AbstractCommand {

    protected ServiceLocator serviceLocator;

    private final boolean isSecure;

    public AbstractCommand(boolean isSecure) {
        this.isSecure = isSecure;
    }

    public void setServiceLocator(Bootstrap serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute() throws Exception;

    public RoleType[] getRoles() {
        return null;
    }

}
