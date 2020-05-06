package ru.naumkin.tm.command.project;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
import java.util.List;

public final class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-update";
    }

    @Override
    public String getDescription() {
        return "Update selected project.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[PROJECT UPDATE]");
        final IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Projects available to update:");
        List<Project> list = new ArrayList<>();
        int index = 1;
        final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (Project project: projectService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
            list.add(project);
        }
        serviceLocator.getTerminalService().showMessage("Choose project to update by number:");
        Project project = list.get(Integer.parseInt(serviceLocator.getTerminalService().readLine()) - 1);
        final String name = project.getName();
        serviceLocator.getTerminalService().showMessage("Updating project:");
        serviceLocator.getTerminalService().showMessage("id: " + project.getId() +
                ", name: " + project.getName());
        serviceLocator.getTerminalService().showMessage("Enter new name:");
        project.setName(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new description:");
        project.setDescription(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy):");
        project.setDateStart(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
        serviceLocator.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy):");
        project.setDateFinish(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
        try {
            projectService.merge(project, name);
        } catch (NameIsEmptyException | ProjectIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
