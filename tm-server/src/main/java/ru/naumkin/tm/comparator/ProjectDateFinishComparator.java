package ru.naumkin.tm.comparator;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.ProjectIsNullException;

import java.util.Comparator;

@NoArgsConstructor
public final class ProjectDateFinishComparator implements Comparator<Project> {

    @Override
    public int compare(@NotNull final Project projectOne, @NotNull final Project projectTwo) {
        if (projectOne.getDateFinish() == null) {
            throw new ProjectIsNullException();
        }
        if (projectTwo.getDateFinish() == null) {
            throw new ProjectIsNullException();
        }
        return projectOne.getDateFinish().compareTo(projectTwo.getDateFinish());
    }

}
