package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Project;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Comparator;
import java.util.Date;

@NoArgsConstructor
public final class ProjectDateStartComparator implements Comparator<Project> {

    @Override
    public int compare(@NotNull final Project projectOne, @NotNull final Project projectTwo) {
        if (projectOne.getDateStart() == null) {
            throw new RuntimeException();
        }
        if (projectTwo.getDateStart() == null) {
            throw new RuntimeException();
        }
        @NotNull final XMLGregorianCalendar projectOneXmlStartDate = projectOne.getDateStart();
        @NotNull final XMLGregorianCalendar projectTwoXmlStartDate = projectTwo.getDateStart();
        @NotNull final Date projectOneStartDate = DateFormatter.convertToDate(projectOneXmlStartDate);
        @NotNull final Date projectTwoStartDate = DateFormatter.convertToDate(projectTwoXmlStartDate);
        return projectOneStartDate.compareTo(projectTwoStartDate);
    }

}
