package ru.naumkin.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IDomainService;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.dto.Domain;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

import javax.xml.bind.*;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public final class DomainService implements IDomainService {

    @NotNull
    private IProjectService projectService;

    @NotNull
    private ITaskService taskService;

    @NotNull
    private IUserService userService;

    public DomainService(@NotNull final IProjectService projectService,
                         @NotNull final ITaskService taskService,
                         @NotNull final IUserService userService
    ) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @Override
    public void loadBinaryData() throws IOException, ClassNotFoundException, SQLException {
        @NotNull final File file = new File(DataConstant.BINARY_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        persistProject(objectInputStream.readObject());
        persistTask(objectInputStream.readObject());
        persistUser(objectInputStream.readObject());
        objectInputStream.close();
    }

    @Override
    public void saveBinaryData() throws IOException, SQLException {
        @NotNull final Project[] projects = projectService.findAll().toArray(new Project[0]);
        @NotNull final Task[] tasks = taskService.findAll().toArray(new Task[0]);
        @NotNull final User[] users = userService.findAll().toArray(new User[0]);
        @NotNull final File file = new File(DataConstant.BINARY_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
    }

    @Override
    public void loadJsonDataFasterXml() throws IOException, SQLException {
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final Domain domain = objectMapper.readValue(file, Domain.class);
        save(domain);
    }

    @Override
    public void saveJsonDataFasterXml() throws IOException, SQLException {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
    }

    @Override
    public void loadJsonDataJaxb() throws IOException, JAXBException, SQLException {
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream =
                new ObjectInputStream(fileInputStream);
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
        @NotNull final Domain domain = (Domain) unmarshaller.unmarshal(objectInputStream);
        objectInputStream.close();
        save(domain);
    }

    @Override
    public void saveJsonDataJaxb() throws IOException, SQLException, JAXBException {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
        marshaller.marshal(domain, objectOutputStream);
        objectOutputStream.close();
    }

    @Override
    public void loadXmlDataFasterXml() throws IOException, SQLException {
        @NotNull final File file = new File(DataConstant.XML_FILE);
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        @NotNull final Domain domain = objectMapper.readValue(file, Domain.class);
        save(domain);
    }

    @Override
    public void saveXmlDataFasterXml() throws IOException, SQLException {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.XML_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
    }

    @Override
    public void loadXmlDataJaxb() throws IOException, JAXBException, SQLException {
        @NotNull final File file = new File(DataConstant.XML_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream =
                new ObjectInputStream(fileInputStream);
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Unmarshaller unmarshaller = context.createUnmarshaller();
        @NotNull final Domain domain = (Domain) unmarshaller.unmarshal(objectInputStream);
        objectInputStream.close();
        save(domain);
    }

    @Override
    public void saveXmlDataJaxb() throws IOException, SQLException, JAXBException {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.XML_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        @NotNull final JAXBContext context = JAXBContext.newInstance(Domain.class);
        @NotNull final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(domain, objectOutputStream);
        objectOutputStream.close();
    }

    @NotNull
    @Override
    public Domain load() throws SQLException {
        @NotNull Domain domain = new Domain();
        @NotNull final List<Project> projects = new LinkedList<>(projectService.findAll());
        @NotNull final List<Task> tasks = new LinkedList<>(taskService.findAll());
        @NotNull final List<User> users = new LinkedList<>(userService.findAll());
        domain.setProjects(projects);
        domain.setTasks(tasks);
        domain.setUsers(users);
        return domain;
    }

    @Override
    public void save(@NotNull final Domain domain) throws SQLException {
        boolean nullCheck = domain.getProjects() == null ||
                domain.getTasks() == null ||
                domain.getUsers() == null;
        if (nullCheck) {
            throw new RuntimeException();
        }
        for (@NotNull final Project project: domain.getProjects()) {
            projectService.persist(project);
        }
        for (@NotNull final Task task: domain.getTasks()) {
            taskService.persist(task);
        }
        for (@NotNull final User user: domain.getUsers()) {
            userService.persist(user);
        }
    }

    private void persistTask(@NotNull final Object object) throws SQLException {
        if (!(object instanceof Task[])) {
            return;
        }
        @NotNull final Task[] tasks = (Task[]) object;
        for (@NotNull final Task toPersist: tasks) {
            taskService.persist(toPersist);
        }

    }

    private void persistProject(@NotNull final Object object) throws SQLException {
        if (!(object instanceof Project[])) {
            return;
        }
        @NotNull final Project[] projects = (Project[]) object;
        for (@NotNull final Project toPersist: projects) {
            projectService.persist(toPersist);
        }
    }

    private void persistUser(@NotNull final Object object) throws SQLException {
        if (!(object instanceof User[])) {
            return;
        }
        @NotNull final User[] users = (User[]) object;
        for (User user: users) {
            if (userService.isRoleAdmin(user.getId())) {
                continue;
            }
            userService.persist(user);
        }
    }

}
