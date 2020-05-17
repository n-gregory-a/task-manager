package ru.naumkin.tm.util;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.Project;

import java.util.Comparator;

@NoArgsConstructor
public class ProjectStatusComparator implements Comparator<Project> {

    @Override
    public int compare(@NotNull final Project projectOne, @NotNull final Project projectTwo) {
        return projectOne.getStatus().compareTo(projectTwo.getStatus());
    }

}
