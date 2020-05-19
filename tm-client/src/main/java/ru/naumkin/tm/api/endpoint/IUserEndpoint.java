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
 * 2020-05-19T16:49:43.965+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "IUserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface IUserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findAllUsersRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findAllUsersResponse")
    @RequestWrapper(localName = "findAllUsers", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllUsers")
    @ResponseWrapper(localName = "findAllUsersResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindAllUsersResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.naumkin.tm.api.endpoint.User> findAllUsers(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/createUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User createUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.RoleType arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/isRoleAdminRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/isRoleAdminResponse")
    @RequestWrapper(localName = "isRoleAdmin", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.IsRoleAdmin")
    @ResponseWrapper(localName = "isRoleAdminResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.IsRoleAdminResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean isRoleAdmin(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/mergeUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/mergeUserResponse")
    @RequestWrapper(localName = "mergeUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeUser")
    @ResponseWrapper(localName = "mergeUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.MergeUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User mergeUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/loadUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/loadUserResponse")
    @RequestWrapper(localName = "loadUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadUser")
    @ResponseWrapper(localName = "loadUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadUserResponse")
    public void loadUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<ru.naumkin.tm.api.endpoint.User> arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/setCurrentUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/setCurrentUserResponse")
    @RequestWrapper(localName = "setCurrentUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SetCurrentUser")
    @ResponseWrapper(localName = "setCurrentUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SetCurrentUserResponse")
    public void setCurrentUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeUserResponse")
    @RequestWrapper(localName = "removeUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveUser")
    @ResponseWrapper(localName = "removeUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User removeUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeAllUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/removeAllUserResponse")
    @RequestWrapper(localName = "removeAllUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllUser")
    @ResponseWrapper(localName = "removeAllUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.RemoveAllUserResponse")
    public void removeAllUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findOneUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/findOneUserResponse")
    @RequestWrapper(localName = "findOneUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneUser")
    @ResponseWrapper(localName = "findOneUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.FindOneUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User findOneUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/getCurrentUserIdRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/getCurrentUserIdResponse")
    @RequestWrapper(localName = "getCurrentUserId", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.GetCurrentUserId")
    @ResponseWrapper(localName = "getCurrentUserIdResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.GetCurrentUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getCurrentUserId(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/getCurrentUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/getCurrentUserResponse")
    @RequestWrapper(localName = "getCurrentUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.GetCurrentUser")
    @ResponseWrapper(localName = "getCurrentUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.GetCurrentUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User getCurrentUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/persistUserRequest", output = "http://endpoint.api.tm.naumkin.ru/IUserEndpoint/persistUserResponse")
    @RequestWrapper(localName = "persistUser", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistUser")
    @ResponseWrapper(localName = "persistUserResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.PersistUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.User persistUser(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.User arg1
    );
}
