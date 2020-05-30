package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.enumerated.Status;
import ru.naumkin.tm.util.DateFormatter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public final class Task extends AbstractEntity {

    @NotNull
    @Column(name = "description")
    private String description = "";

    @Nullable
    @Column(name = "data_start")
    private Date dateStart = null;

    @Nullable
    @Column(name = "date_finish")
    private Date dateFinish = null;

    @Nullable
    @ManyToOne
    private Project project;

    @Nullable
    @ManyToOne
    private User user;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNED;

    public Task(@NotNull final String name) {
        setName(name);
    }

}
