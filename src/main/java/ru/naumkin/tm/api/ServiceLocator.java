package ru.naumkin.tm.api;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.ITerminalService;
import ru.naumkin.tm.api.service.IUserService;

public interface ServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IUserService getUserService();

    ITerminalService getTerminalService();

}
