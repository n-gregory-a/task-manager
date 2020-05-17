package ru.naumkin.tm.api.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-16T20:03:37.600+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "IProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface IProjectEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/mergeProjectRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/mergeProjectResponse")
    @RequestWrapper(localName = "mergeProject", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeProject")
    @ResponseWrapper(localName = "mergeProjectResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project mergeProject(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Project arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findOneProjectByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findOneProjectByUserIdResponse")
    @RequestWrapper(localName = "findOneProjectByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneProjectByUserId")
    @ResponseWrapper(localName = "findOneProjectByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneProjectByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project findOneProjectByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDateStartRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDateStartResponse")
    @RequestWrapper(localName = "sortProjectsByDateStart", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDateStart")
    @ResponseWrapper(localName = "sortProjectsByDateStartResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDateStartResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> sortProjectsByDateStart(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByNameRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByNameResponse")
    @RequestWrapper(localName = "sortProjectsByName", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByName")
    @ResponseWrapper(localName = "sortProjectsByNameResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> sortProjectsByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeProjectByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeProjectByUserIdResponse")
    @RequestWrapper(localName = "removeProjectByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveProjectByUserId")
    @ResponseWrapper(localName = "removeProjectByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveProjectByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project removeProjectByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Project arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findAllProjectsRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findAllProjectsResponse")
    @RequestWrapper(localName = "findAllProjects", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllProjects")
    @ResponseWrapper(localName = "findAllProjectsResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> findAllProjects()
;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByStatusRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByStatusResponse")
    @RequestWrapper(localName = "sortProjectsByStatus", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByStatus")
    @ResponseWrapper(localName = "sortProjectsByStatusResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> sortProjectsByStatus(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeAllProjectsRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeAllProjectsResponse")
    @RequestWrapper(localName = "removeAllProjects", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllProjects")
    @ResponseWrapper(localName = "removeAllProjectsResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllProjectsResponse")
    public void removeAllProjects()
;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findOneProjectRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findOneProjectResponse")
    @RequestWrapper(localName = "findOneProject", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneProject")
    @ResponseWrapper(localName = "findOneProjectResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project findOneProject(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeAllProjectsByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeAllProjectsByUserIdResponse")
    @RequestWrapper(localName = "removeAllProjectsByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllProjectsByUserId")
    @ResponseWrapper(localName = "removeAllProjectsByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllProjectsByUserIdResponse")
    public void removeAllProjectsByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findAllProjectsByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/findAllProjectsByUserIdResponse")
    @RequestWrapper(localName = "findAllProjectsByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllProjectsByUserId")
    @ResponseWrapper(localName = "findAllProjectsByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllProjectsByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> findAllProjectsByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDateFinishRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDateFinishResponse")
    @RequestWrapper(localName = "sortProjectsByDateFinish", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDateFinish")
    @ResponseWrapper(localName = "sortProjectsByDateFinishResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDateFinishResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> sortProjectsByDateFinish(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/loadProjectRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/loadProjectResponse")
    @RequestWrapper(localName = "loadProject", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadProject")
    @ResponseWrapper(localName = "loadProjectResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadProjectResponse")
    public void loadProject(

        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<ru.naumkin.tm.api.endpoint.Project> arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDescriptionRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/sortProjectsByDescriptionResponse")
    @RequestWrapper(localName = "sortProjectsByDescription", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDescription")
    @ResponseWrapper(localName = "sortProjectsByDescriptionResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortProjectsByDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Project> sortProjectsByDescription(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeProjectRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/removeProjectResponse")
    @RequestWrapper(localName = "removeProject", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveProject")
    @ResponseWrapper(localName = "removeProjectResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project removeProject(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Project arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/persistProjectRequest", output = "http://endpoint.api.tm.naumkin.ru/IProjectEndpoint/persistProjectResponse")
    @RequestWrapper(localName = "persistProject", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistProject")
    @ResponseWrapper(localName = "persistProjectResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Project persistProject(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Project arg0
    );
}