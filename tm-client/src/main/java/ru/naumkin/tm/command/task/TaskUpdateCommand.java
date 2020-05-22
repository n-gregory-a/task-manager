package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-update";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Update task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[TASK UPDATE]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        bootstrap.getTerminalService().showMessage("Tasks available to update:");
        @NotNull final List<Task> list = new ArrayList<>();
        int index = 1;
        for (@NotNull final Task task:
                taskEndpoint.findAllTasksByUserId(bootstrap.getCurrentSession())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
            list.add(task);
        }
        bootstrap.getTerminalService().showMessage("Choose task to update by number:");
        @NotNull final Task task = list.get(Integer
                .parseInt(bootstrap.getTerminalService().readLine()) - 1);
        @Nullable final String name = task.getName();
        bootstrap.getTerminalService().showMessage("Updating task:");
        bootstrap.getTerminalService().showMessage("id: " + task.getId() +
                ", name: " + task.getName());
        bootstrap.getTerminalService().showMessage("Enter new name: ");
        task.setName(bootstrap.getTerminalService().readLine());
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
        bootstrap.getTerminalService()
                .showMessage("Enter new status (\"planned\", \"in progress\", \"completed\"):");
        @NotNull final String status = bootstrap.getTerminalService().readLine();
        task.setStatus(Status.fromValue(status));
            taskEndpoint.mergeTask(bootstrap.getCurrentSession(), task, name);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
