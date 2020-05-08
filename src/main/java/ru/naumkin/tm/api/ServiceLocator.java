package ru.naumkin.tm.api;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.api.service.IUserService;

public interface ServiceLocator {

    @NotNull
    IProjectService getProjectService();

    @NotNull
    ITaskService getTaskService();

    @NotNull
    IUserService getUserService();

    @NotNull
    ITerminalService getTerminalService();

}
