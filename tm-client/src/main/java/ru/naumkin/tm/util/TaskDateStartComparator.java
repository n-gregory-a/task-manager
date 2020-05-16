package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Task;

import java.util.Comparator;

@NoArgsConstructor
public final class TaskDateStartComparator implements Comparator<Task> {

    @Override
    public int compare(@NotNull final Task taskOne, @NotNull final Task taskTwo) {
        if (taskOne.getDateStart() == null) {
            throw new RuntimeException();
        }
        if (taskTwo.getDateStart() == null) {
            throw new RuntimeException();
        }
        return taskOne.getDateStart().compareTo(taskTwo.getDateStart());
    }

}
