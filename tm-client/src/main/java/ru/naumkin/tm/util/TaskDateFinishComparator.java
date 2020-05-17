package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Task;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Comparator;
import java.util.Date;

@NoArgsConstructor
public final class TaskDateFinishComparator implements Comparator<Task> {

    @Override
    public int compare(@NotNull final Task taskOne, @NotNull final Task taskTwo) {
        if (taskOne.getDateFinish() == null) {
            throw new RuntimeException();
        }
        if (taskTwo.getDateFinish() == null) {
            throw new RuntimeException();
        }
        @NotNull final XMLGregorianCalendar taskOneXmlFinishDate = taskOne.getDateFinish();
        @NotNull final XMLGregorianCalendar taskTwoXmlFinishDate = taskTwo.getDateFinish();
        @NotNull final Date taskOneFinishDate = DateFormatter.convertToDate(taskOneXmlFinishDate);
        @NotNull final Date taskTwoFinishDate = DateFormatter.convertToDate(taskTwoXmlFinishDate);
        return taskOneFinishDate.compareTo(taskTwoFinishDate);
    }

}
