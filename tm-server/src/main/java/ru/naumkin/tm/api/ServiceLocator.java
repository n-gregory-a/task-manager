package ru.naumkin.tm.api;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.*;

public interface ServiceLocator {

    @NotNull
    IProjectService getProjectService();

    @NotNull
    ITaskService getTaskService();

    @NotNull
    IUserService getUserService();

    @NotNull
    IPropertyService getPropertyService();

    @NotNull
    IDomainService getDomainService();

    @NotNull
    ISessionService getSessionService();

}
