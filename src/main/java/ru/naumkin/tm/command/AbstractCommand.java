package ru.naumkin.tm.command;

import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.enumerated.RoleType;

public abstract class AbstractCommand {

    protected ServiceLocator serviceLocator;

    private final boolean isSecure;

    public AbstractCommand(final boolean isSecure) {
        this.isSecure = isSecure;
    }

    public void setServiceLocator(final ServiceLocator serviceLocator) {
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
