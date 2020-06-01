package ru.naumkin.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.enumerated.Status;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public final class ProjectDTO extends AbstractDTO {

    @NotNull
    private String description = "";

    @Nullable
    private Date dateStart = null;

    @Nullable
    private Date dateFinish = null;

    @Nullable
    private String userId = null;

    @NotNull
    private Status status = Status.PLANNED;

    public ProjectDTO(@NotNull final String name) {
        setName(name);
    }

    @NotNull
    public Project convertToProject(
            @NotNull final ProjectDTO projectDTO,
            @NotNull final ServiceLocator serviceLocator
    ) {
        @NotNull final Project project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setDateStart(projectDTO.getDateStart());
        project.setDateFinish(projectDTO.getDateFinish());
        project.setUser(serviceLocator.getUserService().findOneById(projectDTO.getUserId()));
        project.setStatus(projectDTO.getStatus());
        project.setTasks(serviceLocator.getTaskService()
                .findAllByProjectId(projectDTO.getUserId(), projectDTO.getId()));
        return project;
    }

}
