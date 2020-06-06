package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.TaskDTO;
import ru.naumkin.tm.enumerated.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Cacheable
@Table(name = "task")
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public final class Task extends AbstractEntity {

    @NotNull
    @Column(name = "description")
    private String description = "";

    @Nullable
    @Column(name = "date_start")
    private Date dateStart = null;

    @Nullable
    @Column(name = "date_finish")
    private Date dateFinish = null;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNED;

    public Task(@NotNull final String name) {
        setName(name);
    }

    @NotNull
    public TaskDTO convertToTaskDTO(@NotNull final Task task) {
        @NotNull final TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDateStart(task.getDateStart());
        taskDTO.setDateFinish(task.getDateFinish());
        try {
            taskDTO.setProjectId(task.getProject().getId());
        } catch (Exception e) {
            taskDTO.setProjectId(null);
        }
        taskDTO.setUserId(task.getUser().getId());
        taskDTO.setStatus(task.getStatus());
        return taskDTO;
    }

}
