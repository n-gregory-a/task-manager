package ru.naumkin.tm.api;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.view.TerminalService;

public interface ServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IUserService getUserService();

    TerminalService getTerminalService();

}
