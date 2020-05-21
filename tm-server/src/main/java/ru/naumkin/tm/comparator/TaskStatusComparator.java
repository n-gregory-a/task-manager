package ru.naumkin.tm.comparator;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Task;

import java.util.Comparator;

@NoArgsConstructor
public class TaskStatusComparator implements Comparator<Task> {

    @Override
    public int compare(@NotNull final Task taskOne, @NotNull final Task taskTwo) {
        return taskOne.getStatus().compareTo(taskTwo.getStatus());
    }

}
