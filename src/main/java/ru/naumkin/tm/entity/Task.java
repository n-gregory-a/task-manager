package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public final class Task extends AbstractEntity {

    @NotNull
    private String description = "";

    @NotNull
    private LocalDate dateStart = LocalDate.now();

    @Nullable
    private LocalDate dateFinish = null;

    @Nullable
    private String projectId = null;

    @Nullable
    private String userId = null;

    public Task(@NotNull final String name) {
        setName(name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
