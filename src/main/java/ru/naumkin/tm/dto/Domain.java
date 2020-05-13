package ru.naumkin.tm.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Setter
@XmlRootElement
@NoArgsConstructor
public final class Domain implements Serializable {

    @Nullable
    @XmlElement(name = "project")
    private List<Project> projects;

    @Nullable
    @XmlElement(name = "task")
    private List<Task> tasks;

    @Nullable
    @XmlElement(name = "user")
    private List<User> users;

    @Nullable
    @XmlTransient
    public List<Project> getProjects() {
        return this.projects;
    }

    @Nullable
    @XmlTransient
    public List<Task> getTasks() {
        return this.tasks;
    }

    @Nullable
    @XmlTransient
    public List<User> getUsers() {
        return this.users;
    }

}
