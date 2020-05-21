package ru.naumkin.tm.comparator;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.TaskIsNullException;

import java.util.Comparator;

@NoArgsConstructor
public final class TaskDateFinishComparator implements Comparator<Task> {

    @Override
    public int compare(@NotNull final Task taskOne, @NotNull final Task taskTwo) {
        if (taskOne.getDateFinish() == null) {
            throw new TaskIsNullException();
        }
        if (taskTwo.getDateFinish() == null) {
            throw new TaskIsNullException();
        }
        return taskOne.getDateFinish().compareTo(taskTwo.getDateFinish());
    }

}
