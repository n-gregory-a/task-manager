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
 * 2020-05-26T19:59:12.709+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "IUserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface IUserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findAllUsersRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findAllUsersResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findAllUsers/Fault/Exception")})
    @RequestWrapper(localName = "findAllUsers", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllUsers")
    @ResponseWrapper(localName = "findAllUsersResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllUsersResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.User> findAllUsers()
 throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeAllUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeAllUserResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeAllUser/Fault/Exception")})
    @RequestWrapper(localName = "removeAllUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllUser")
    @ResponseWrapper(localName = "removeAllUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllUserResponse")
    public void removeAllUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/isRoleAdminRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/isRoleAdminResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/isRoleAdmin/Fault/Exception")})
    @RequestWrapper(localName = "isRoleAdmin", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.IsRoleAdmin")
    @ResponseWrapper(localName = "isRoleAdminResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.IsRoleAdminResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean isRoleAdmin(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/mergeUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/mergeUserResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/mergeUser/Fault/Exception")})
    @RequestWrapper(localName = "mergeUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeUser")
    @ResponseWrapper(localName = "mergeUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeUserResponse")
    public void mergeUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findOneUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findOneUserResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findOneUser/Fault/Exception")})
    @RequestWrapper(localName = "findOneUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneUser")
    @ResponseWrapper(localName = "findOneUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User findOneUser(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/persistUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/persistUserResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/persistUser/Fault/Exception")})
    @RequestWrapper(localName = "persistUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistUser")
    @ResponseWrapper(localName = "persistUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistUserResponse")
    public void persistUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg0
    ) throws Exception;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeUserResponse", fault = {@FaultAction(className = Exception.class, value = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeUser/Fault/Exception")})
    @RequestWrapper(localName = "removeUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveUser")
    @ResponseWrapper(localName = "removeUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveUserResponse")
    public void removeUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1
    ) throws Exception;
}
