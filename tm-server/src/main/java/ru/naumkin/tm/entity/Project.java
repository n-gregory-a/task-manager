package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.enumerated.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "project")
@NoArgsConstructor
public final class Project extends AbstractEntity {

    @NotNull
    @Column(name = "description")
    private String description = "";

    @Nullable
    @Column(name = "data_start")
    private Date dateStart = null;

    @Nullable
    @Column(name = "date_finish")
    private Date dateFinish = null;

    @NotNull
    @ManyToOne
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

}
