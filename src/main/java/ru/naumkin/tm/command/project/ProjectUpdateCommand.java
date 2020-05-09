package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
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
        serviceLocator.getTerminalService().showMessage("[PROJECT UPDATE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Projects available to update:");
        @NotNull final List<Project> list = new ArrayList<>();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Project project: projectService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
            list.add(project);
        }
        serviceLocator.getTerminalService().showMessage("Choose project to update by number:");
        @NotNull final Project project = list.get(Integer
                .parseInt(serviceLocator.getTerminalService().readLine()) - 1);
        @NotNull final String name = project.getName();
        serviceLocator.getTerminalService().showMessage("Updating project:");
        serviceLocator.getTerminalService().showMessage("id: " + project.getId() +
                ", name: " + project.getName());
        serviceLocator.getTerminalService().showMessage("Enter new name:");
        project.setName(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new description:");
        project.setDescription(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy):");
        String startDate = serviceLocator.getTerminalService().readLine();
        project.setDateStart(DateFormatter.convertStringToDate(startDate));
        serviceLocator.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy):");
        String finishDate = serviceLocator.getTerminalService().readLine();
        project.setDateFinish(DateFormatter.convertStringToDate(finishDate));
        projectService.merge(project, name);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
