package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.api.endpoint.Status;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-update";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Update selected project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT UPDATE]");
        @NotNull final IProjectEndpoint projectService = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Projects available to update:");
        @NotNull final List<Project> list = new ArrayList<>();
        int index = 1;
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        for (@NotNull final Project project: projectService.findAllProjectsByUserId(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". " + project.toString());
            list.add(project);
        }
        bootstrap.getTerminalService().showMessage("Choose project to update by number:");
        @NotNull final Project project = list.get(Integer
                .parseInt(bootstrap.getTerminalService().readLine()) - 1);
        @NotNull final String name = project.getName();
        bootstrap.getTerminalService().showMessage("Updating project:");
        bootstrap.getTerminalService().showMessage("id: " + project.getId() +
                ", name: " + project.getName());
        bootstrap.getTerminalService().showMessage("Enter new name:");
        project.setName(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new description:");
        project.setDescription(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy):");
        @NotNull final String startDate = bootstrap.getTerminalService().readLine();
        @NotNull Date date = DateFormatter.convertStringToDate(startDate);
        project.setDateStart(DateFormatter.convertToXmlGregorianCalendar(date));
        bootstrap.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy):");
        @NotNull final String finishDate = bootstrap.getTerminalService().readLine();
        date = DateFormatter.convertStringToDate(finishDate);
        project.setDateFinish(DateFormatter.convertToXmlGregorianCalendar(date));
        bootstrap.getTerminalService()
                .showMessage("Enter new status (\"planned\", \"in progress\", \"completed\"):");
        @NotNull final String status = bootstrap.getTerminalService().readLine();
        project.setStatus(Status.fromValue(status));
        projectService.mergeProject(project, name);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
