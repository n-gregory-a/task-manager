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
 * 2020-05-19T14:40:08.412+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "ITaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ITaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateStartRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateStartResponse")
    @RequestWrapper(localName = "sortTasksByDateStart", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateStart")
    @ResponseWrapper(localName = "sortTasksByDateStartResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateStartResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDateStart(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksByUserIdResponse")
    @RequestWrapper(localName = "findAllTasksByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasksByUserId")
    @ResponseWrapper(localName = "findAllTasksByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasksByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> findAllTasksByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskResponse")
    @RequestWrapper(localName = "removeTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTask")
    @ResponseWrapper(localName = "removeTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task removeTask(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksResponse")
    @RequestWrapper(localName = "removeAllTasks", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasks")
    @ResponseWrapper(localName = "removeAllTasksResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasksResponse")
    public void removeAllTasks(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskByUserIdResponse")
    @RequestWrapper(localName = "findOneTaskByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTaskByUserId")
    @ResponseWrapper(localName = "findOneTaskByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTaskByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task findOneTaskByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateFinishRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateFinishResponse")
    @RequestWrapper(localName = "sortTasksByDateFinish", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateFinish")
    @ResponseWrapper(localName = "sortTasksByDateFinishResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateFinishResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDateFinish(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDescriptionRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDescriptionResponse")
    @RequestWrapper(localName = "sortTasksByDescription", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDescription")
    @ResponseWrapper(localName = "sortTasksByDescriptionResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDescription(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByStatusRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByStatusResponse")
    @RequestWrapper(localName = "sortTasksByStatus", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByStatus")
    @ResponseWrapper(localName = "sortTasksByStatusResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByStatus(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByNameRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByNameResponse")
    @RequestWrapper(localName = "sortTasksByName", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByName")
    @ResponseWrapper(localName = "sortTasksByNameResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByName(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/loadTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/loadTaskResponse")
    @RequestWrapper(localName = "loadTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadTask")
    @ResponseWrapper(localName = "loadTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadTaskResponse")
    public void loadTask(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<ru.naumkin.tm.api.endpoint.Task> arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksByUserIdResponse")
    @RequestWrapper(localName = "removeAllTasksByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasksByUserId")
    @ResponseWrapper(localName = "removeAllTasksByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasksByUserIdResponse")
    public void removeAllTasksByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksResponse")
    @RequestWrapper(localName = "findAllTasks", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasks")
    @ResponseWrapper(localName = "findAllTasksResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> findAllTasks(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/persistTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/persistTaskResponse")
    @RequestWrapper(localName = "persistTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistTask")
    @ResponseWrapper(localName = "persistTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task persistTask(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/mergeTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/mergeTaskResponse")
    @RequestWrapper(localName = "mergeTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeTask")
    @ResponseWrapper(localName = "mergeTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task mergeTask(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskResponse")
    @RequestWrapper(localName = "findOneTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTask")
    @ResponseWrapper(localName = "findOneTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task findOneTask(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskByUserIdResponse")
    @RequestWrapper(localName = "removeTaskByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTaskByUserId")
    @ResponseWrapper(localName = "removeTaskByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTaskByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task removeTaskByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg2
    );
}
