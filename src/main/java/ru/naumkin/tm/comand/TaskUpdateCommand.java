package ru.naumkin.tm.comand;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;
import ru.naumkin.tm.util.DateFormatter;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-update";
    }

    @Override
    public String getDescription() {
        return "Update task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[TASK UPDATE]");
        bootstrap.getView().showMessage("Enter task name:");
        Task task = new Task(bootstrap.getView().readLine());
        String name = task.getName();
        TaskService taskService = bootstrap.getTaskService();

        bootstrap.getView().showMessage("Enter new name: ");
        task.setName(bootstrap.getView().readLine());

        bootstrap.getView().showMessage("Enter new description: ");
        task.setDescription(bootstrap.getView().readLine());

        bootstrap.getView().showMessage("Enter new start date(dd.mm.yyyy): ");
        task.setDateStart(DateFormatter.convertStringToDate(bootstrap.getView().readLine()));

        bootstrap.getView().showMessage("Enter new finish date(dd.mm.yyyy): ");
        task.setDateFinish(DateFormatter.convertStringToDate(bootstrap.getView().readLine()));

        try {
            taskService.merge(task, name);
        } catch (IllegalArgumentException e) {
            bootstrap.getView().showMessage(e.getMessage());
            return;
        }
        bootstrap.getView().showMessage("[OK]");
    }

}
