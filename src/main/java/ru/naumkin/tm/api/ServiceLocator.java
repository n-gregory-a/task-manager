package ru.naumkin.tm.api;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.view.TerminalService;

import java.util.List;

public interface ServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IService<User> getUserService();

    TerminalService getTerminalService();

    User getCurrentUser();

    void setCurrentUser(final User user);

    List<AbstractCommand> getCommand();

}
