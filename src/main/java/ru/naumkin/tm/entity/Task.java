package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.enumerated.Status;
import ru.naumkin.tm.util.DateFormatter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public final class Task extends AbstractEntity implements Serializable {

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

    public Task(@NotNull final String name) {
        setName(name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id: '" + getId() + '\'' +
                ", name: '" + getName() + '\'' +
                ", description: '" + description + '\'' +
                ", dateStart: " + DateFormatter.convertDateToString(dateStart) +
                ", dateFinish: " + DateFormatter.convertDateToString(dateFinish) +
                ", projectId: '" + projectId + '\'' +
                ", userId: '" + userId + '\'' +
                ", status: " + status.displayStatus() +
                '}';
    }

}
