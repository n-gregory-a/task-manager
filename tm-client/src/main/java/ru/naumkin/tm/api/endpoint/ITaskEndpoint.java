package ru.naumkin.tm.api.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-27T18:06:30.672+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "ITaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ITaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksByUserIdResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeAllTasksByUserId/Fault/Exception")})
    @RequestWrapper(localName = "removeAllTasksByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasksByUserId")
    @ResponseWrapper(localName = "removeAllTasksByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllTasksByUserIdResponse")
    public void removeAllTasksByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateStartRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateStartResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateStart/Fault/Exception")})
    @RequestWrapper(localName = "sortTasksByDateStart", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateStart")
    @ResponseWrapper(localName = "sortTasksByDateStartResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateStartResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDateStart(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksByUserIdResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findAllTasksByUserId/Fault/Exception")})
    @RequestWrapper(localName = "findAllTasksByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasksByUserId")
    @ResponseWrapper(localName = "findAllTasksByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllTasksByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> findAllTasksByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskByUserIdResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/findOneTaskByUserId/Fault/Exception")})
    @RequestWrapper(localName = "findOneTaskByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTaskByUserId")
    @ResponseWrapper(localName = "findOneTaskByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneTaskByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Task findOneTaskByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/mergeTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/mergeTaskResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/mergeTask/Fault/Exception")})
    @RequestWrapper(localName = "mergeTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeTask")
    @ResponseWrapper(localName = "mergeTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeTaskResponse")
    public void mergeTask(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/persistTaskRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/persistTaskResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/persistTask/Fault/Exception")})
    @RequestWrapper(localName = "persistTask", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistTask")
    @ResponseWrapper(localName = "persistTaskResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistTaskResponse")
    public void persistTask(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateFinishRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateFinishResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDateFinish/Fault/Exception")})
    @RequestWrapper(localName = "sortTasksByDateFinish", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateFinish")
    @ResponseWrapper(localName = "sortTasksByDateFinishResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDateFinishResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDateFinish(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDescriptionRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDescriptionResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByDescription/Fault/Exception")})
    @RequestWrapper(localName = "sortTasksByDescription", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDescription")
    @ResponseWrapper(localName = "sortTasksByDescriptionResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByDescription(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskByUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskByUserIdResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/removeTaskByUserId/Fault/Exception")})
    @RequestWrapper(localName = "removeTaskByUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTaskByUserId")
    @ResponseWrapper(localName = "removeTaskByUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveTaskByUserIdResponse")
    public void removeTaskByUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Task arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByStatusRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByStatusResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByStatus/Fault/Exception")})
    @RequestWrapper(localName = "sortTasksByStatus", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByStatus")
    @ResponseWrapper(localName = "sortTasksByStatusResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByStatus(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByNameRequest", output = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByNameResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/ITaskEndpoint/sortTasksByName/Fault/Exception")})
    @RequestWrapper(localName = "sortTasksByName", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByName")
    @ResponseWrapper(localName = "sortTasksByNameResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SortTasksByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.Task> sortTasksByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception;
}
