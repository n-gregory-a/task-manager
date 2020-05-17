package ru.naumkin.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public final class DomainService implements IDomainService {

    @NotNull
    private final IProjectService projectService;

    @NotNull
    private final ITaskService taskService;

    @NotNull
    private final IUserService userService;

    public DomainService(@NotNull final IProjectService projectService,
                         @NotNull final ITaskService taskService,
                         @NotNull final IUserService userService
    ) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @Override
    public void loadBinaryData() throws Exception {
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
    public void saveBinaryData() throws Exception {
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
    public void loadJsonDataFasterXml() throws Exception{
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final Domain domain = objectMapper.readValue(file, Domain.class);
        save(domain);
    }

    @Override
    public void saveJsonDataFasterXml() throws Exception {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.JSON_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
    }

    @Override
    public void loadJsonDataJaxb() throws Exception {
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
    public void saveJsonDataJaxb() throws Exception {
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
    public void loadXmlDataFasterXml() throws Exception {
        @NotNull final File file = new File(DataConstant.XML_FILE);
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        @NotNull final Domain domain = objectMapper.readValue(file, Domain.class);
        save(domain);
    }

    @Override
    public void saveXmlDataFasterXml() throws Exception {
        @NotNull final Domain domain = load();
        @NotNull final File file = new File(DataConstant.XML_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, domain);
    }

    @Override
    public void loadXmlDataJaxb() throws Exception {
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
    public void saveXmlDataJaxb() throws Exception {
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
    public Domain load() {
        @Nullable final String currentUserId = userService.getCurrentUserId();
        if (currentUserId == null) {
            throw new RuntimeException();
        }
        @NotNull Domain domain = new Domain();
        @NotNull final List<Project> projects = projectService.findAll(currentUserId);
        @NotNull final List<Task> tasks = taskService.findAll(currentUserId);
        @NotNull final List<User> users = new LinkedList<>(userService.findAll());
        domain.setProjects(projects);
        domain.setTasks(tasks);
        domain.setUsers(users);
        return domain;
    }

    @Override
    public void save(@NotNull final Domain domain) {
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

    private void persistTask(@NotNull final Object object) {
        if (!(object instanceof Task[])) {
            return;
        }
        @NotNull final Task[] tasks = (Task[]) object;
        taskService.persist(tasks);
    }

    private void persistProject(@NotNull final Object object) {
        if (!(object instanceof Project[])) {
            return;
        }
        @NotNull final Project[] projects = (Project[]) object;
        projectService.persist(projects);
    }

    private void persistUser(@NotNull final Object object) {
        if (!(object instanceof User[])) {
            return;
        }
        @NotNull final User[] users = (User[]) object;
        for (User user: users) {
            if (userService.isRoleAdmin(user)) {
                continue;
            }
            userService.persist(user);
        }
    }

}
