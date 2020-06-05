package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.ProjectDTO;
import ru.naumkin.tm.enumerated.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Cacheable
@NoArgsConstructor
@Table(name = "project")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public final class Project extends AbstractEntity {

    @NotNull
    @Column(name = "description")
    private String description = "";

    @Nullable
    @Column(name = "date_start")
    private Date dateStart = null;

    @Nullable
    @Column(name = "date_finish")
    private Date dateFinish = null;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNED;

    @NotNull
    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Project(@NotNull final String name) {
        setName(name);
    }

    @NotNull
    public ProjectDTO convertToProjectDTO(@NotNull final Project project) {
        @NotNull final ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setDateStart(project.getDateStart());
        projectDTO.setDateFinish(project.getDateFinish());
        projectDTO.setUserId(project.getUser().getId());
        projectDTO.setStatus(project.getStatus());
        return projectDTO;
    }

}
