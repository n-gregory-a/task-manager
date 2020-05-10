package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Project;

import java.util.Comparator;

@NoArgsConstructor
public final class ProjectDateStartComparator implements Comparator<Project> {

    @Override
    public int compare(@NotNull final Project projectOne, @NotNull final Project projectTwo) {
        if (projectOne.getDateStart() == null) {
            throw new RuntimeException();
        }
        return projectOne.getDateStart().compareTo(projectTwo.getDateStart());
    }

}
