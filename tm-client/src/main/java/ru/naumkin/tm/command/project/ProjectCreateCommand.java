package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ProjectDTO;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.DateFormatter;

import java.util.Date;

public final class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-create";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create new project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT CREATE]");
        @Nullable final String sessionToken
                = bootstrap.getCurrentSessionToken();
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        @Nullable final ProjectDTO project = new ProjectDTO();
        bootstrap.getTerminalService().showMessage("Enter name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        project.setName(name);
        bootstrap.getTerminalService().showMessage("Enter description:");
        @NotNull final String description = bootstrap.getTerminalService().readLine();
        project.setDescription(description);
        bootstrap.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy): ");
        @NotNull final String startDate = bootstrap.getTerminalService().readLine();
        @NotNull Date date = DateFormatter.convertStringToDate(startDate);
        project.setDateStart(DateFormatter.convertToXmlGregorianCalendar(date));
        bootstrap.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy):");
        @NotNull final String finishDate = bootstrap.getTerminalService().readLine();
        date = DateFormatter.convertStringToDate(finishDate);
        project.setDateFinish(DateFormatter.convertToXmlGregorianCalendar(date));
        project.setUserId(bootstrap.getSessionEndpoint().getUserId(sessionToken));
        projectEndpoint.persistProject(sessionToken, project);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
