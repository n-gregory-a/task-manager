package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.enumerated.Status;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public final class Project extends AbstractEntity {

    @NotNull
    private String description = "";

    @Nullable
    private LocalDate dateStart = LocalDate.now();

    @Nullable
    private LocalDate dateFinish = null;

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
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", userId='" + userId + '\'' +
                '}';
    }
}
