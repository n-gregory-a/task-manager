package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.enumerated.Status;
import ru.naumkin.tm.util.DateFormatter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public final class Project extends AbstractEntity {

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

    public Project(@NotNull final String name) {
        setName(name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id: '" + getId() + '\'' +
                ", name: '" + getName() + '\'' +
                ", description: '" + description + '\'' +
                ", dateStart: " + DateFormatter.convertDateToString(dateStart) +
                ", dateFinish: " + DateFormatter.convertDateToString(dateFinish) +
                ", userId: '" + userId + '\'' +
                ", status: " + status.displayStatus() +
                '}';
    }
}
