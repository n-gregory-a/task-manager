package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Project;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Comparator;
import java.util.Date;

@NoArgsConstructor
public final class ProjectDateFinishComparator implements Comparator<Project> {

    @Override
    public int compare(@NotNull final Project projectOne, @NotNull final Project projectTwo) {
        if (projectOne.getDateFinish() == null) {
            throw new RuntimeException();
        }
        if (projectTwo.getDateFinish() == null) {
            throw new RuntimeException();
        }
        @NotNull final XMLGregorianCalendar projectOneXmlFinishDate = projectOne.getDateFinish();
        @NotNull final XMLGregorianCalendar projectTwoXmlFinishDate = projectTwo.getDateFinish();
        @NotNull final Date projectOneFinishDate = DateFormatter.convertToDate(projectOneXmlFinishDate);
        @NotNull final Date projectTwoFinishDate = DateFormatter.convertToDate(projectTwoXmlFinishDate);
        return projectOneFinishDate.compareTo(projectTwoFinishDate);
    }

}
