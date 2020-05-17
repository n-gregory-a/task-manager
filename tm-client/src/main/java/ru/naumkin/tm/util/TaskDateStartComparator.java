package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Task;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Comparator;
import java.util.Date;

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
        @NotNull final XMLGregorianCalendar taskOneXmlStartDate = taskOne.getDateStart();
        @NotNull final XMLGregorianCalendar taskTwoXmlStartDate = taskTwo.getDateStart();
        @NotNull final Date taskOneStartDate = DateFormatter.convertToDate(taskOneXmlStartDate);
        @NotNull final Date taskTwoStartDate = DateFormatter.convertToDate(taskTwoXmlStartDate);
        return taskOneStartDate.compareTo(taskTwoStartDate);
    }

}
