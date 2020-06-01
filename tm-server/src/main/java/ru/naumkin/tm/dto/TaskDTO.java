package ru.naumkin.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.enumerated.Status;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO extends AbstractDTO {

    @NotNull
    private String description = "";

    @Nullable
    private Date dateStart = null;

    @Nullable
    private Date dateFinish = null;

    @Nullable
    private String projectId = null;

    @Nullable
    private String userId = null;

    @NotNull
    private Status status = Status.PLANNED;

    public TaskDTO(@NotNull final String name) {
        setName(name);
    }

    @NotNull
    public Task convertToTask(
            @NotNull final TaskDTO taskDTO,
            @NotNull final ServiceLocator serviceLocator
    ) {
        @NotNull final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setDateStart(taskDTO.getDateStart());
        task.setDateFinish(taskDTO.getDateFinish());
        task.setProject(serviceLocator.getProjectService()
                .findOne(taskDTO.getUserId(), taskDTO.getProjectId()));
        task.setUser(serviceLocator.getUserService().findOneById(taskDTO.getUserId()));
        task.setStatus(taskDTO.getStatus());
        return task;
    }

}
