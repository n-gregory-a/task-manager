package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.TaskDTO;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.DateFormatter;

import java.util.Date;

public final class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-create";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create new task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[TASK CREATE]");
        @NotNull final String sessionToken = bootstrap.getCurrentSessionToken();
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        @NotNull TaskDTO task = new TaskDTO();
        bootstrap.getTerminalService().showMessage("Enter name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        task.setName(name);
        bootstrap.getTerminalService().showMessage("Enter new description: ");
        task.setDescription(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy): ");
        @NotNull final String startDate = bootstrap.getTerminalService().readLine();
        @NotNull Date date = DateFormatter.convertStringToDate(startDate);
        task.setDateStart(DateFormatter.convertToXmlGregorianCalendar(date));
        bootstrap.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy): ");
        @NotNull final String finishDate = bootstrap.getTerminalService().readLine();
        date = DateFormatter.convertStringToDate(finishDate);
        task.setDateFinish(DateFormatter.convertToXmlGregorianCalendar(date));
        task.setUserId(bootstrap.getSessionEndpoint().getUserId(sessionToken));
        taskEndpoint.persistTask(sessionToken, task);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
