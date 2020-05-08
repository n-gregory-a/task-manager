package ru.naumkin.tm.command;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.enumerated.RoleType;

public abstract class AbstractCommand {

    protected ServiceLocator serviceLocator;

    private final boolean isSecure;

    public AbstractCommand(final boolean isSecure) {
        this.isSecure = isSecure;
    }

    public void setServiceLocator(@NotNull final ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean isSecure() {
        return isSecure;
    }

    @Nullable
    public abstract String getName();

    @Nullable
    public abstract String getDescription();

    public abstract void execute() throws Exception;

    @Nullable
    public RoleType[] getRoles() {
        return null;
    }

}
