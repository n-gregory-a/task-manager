package ru.naumkin.tm.command;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.RoleType;
import ru.naumkin.tm.context.Bootstrap;

@NoArgsConstructor
public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    private boolean isSecure;

    public AbstractCommand(final boolean isSecure) {
        this.isSecure = isSecure;
    }

    public void setBootstrap(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
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
