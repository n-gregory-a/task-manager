package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.dto.ProjectDTO;
import ru.naumkin.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IProjectEndpoint")
public final class ProjectEndpoint extends AbstractEndpoint implements IProjectEndpoint {

    @NotNull
    private IProjectService projectService;

    @NotNull
    private ISessionService sessionService;

    public ProjectEndpoint(@NotNull final ServiceLocator serviceLocator) {
        super(serviceLocator);
        this.projectService = serviceLocator.getProjectService();
        this.sessionService = serviceLocator.getSessionService();
    }

    @Override
    @WebMethod
    public void persistProject(@NotNull final String sessionToken,
                               @NotNull final ProjectDTO projectDTO
    ) throws Exception {
        validate(sessionToken);
        projectService.persist(projectDTO.convertToProject(projectDTO, serviceLocator));
    }

    @Override
    @WebMethod
    public void mergeProject(
            @NotNull final String sessionToken,
            @NotNull final ProjectDTO projectDTO
    ) throws Exception {
        validate(sessionToken);
        projectService.merge(projectDTO.convertToProject(projectDTO, serviceLocator));
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> findAllProjectsByUserId(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects = projectService.findAll(sessionService.getUserId(sessionToken));
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public ProjectDTO findOneProjectByUserId(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        @NotNull final Project project =
                projectService.findOne(sessionService.getUserId(sessionToken), name);
        return project.convertToProjectDTO(project);
    }

    @Override
    @WebMethod
    public void removeProjectByUserId(
            @NotNull final String sessionToken,
            @NotNull final ProjectDTO projectDTO
    ) throws Exception {
        validate(sessionToken);
        @NotNull final Project project =
                projectDTO.convertToProject(projectDTO, serviceLocator);
        projectService.remove(sessionService.getUserId(sessionToken), project);
    }

    @Override
    @WebMethod
    public void removeAllProjectsByUserId(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        projectService.removeAll(sessionService.getUserId(sessionToken));
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> sortProjectsByDateStart(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects =
                projectService.sortByDateStart(sessionService.getUserId(sessionToken));
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> sortProjectsByDateFinish(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects =
                projectService.sortByDateFinish(sessionService.getUserId(sessionToken));
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> sortProjectsByStatus(
            @NotNull final String sessionToken
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects =
                projectService.sortByStatus(sessionService.getUserId(sessionToken));
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> sortProjectsByName(
            @NotNull final String sessionToken,
            @NotNull final String name
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects =
                projectService.sortByName(sessionService.getUserId(sessionToken), name);
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public List<ProjectDTO> sortProjectsByDescription(
            @NotNull final String sessionToken,
            @NotNull final String description
    ) throws Exception {
        validate(sessionToken);
        @NotNull final List<Project> projects =
                projectService.sortByDescription(sessionService.getUserId(sessionToken), description);
        @NotNull List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (@NotNull final Project project: projects) {
            @NotNull final ProjectDTO projectDTO = project.convertToProjectDTO(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

}
