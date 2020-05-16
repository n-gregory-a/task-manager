
package ru.naumkin.tm.api.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.naumkin.tm.api.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "createUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "createUserResponse");
    private final static QName _FindAllUsers_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findAllUsers");
    private final static QName _FindAllUsersResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findAllUsersResponse");
    private final static QName _FindOneUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findOneUser");
    private final static QName _FindOneUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findOneUserResponse");
    private final static QName _GetCurrentUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "getCurrentUser");
    private final static QName _GetCurrentUserId_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "getCurrentUserId");
    private final static QName _GetCurrentUserIdResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "getCurrentUserIdResponse");
    private final static QName _GetCurrentUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "getCurrentUserResponse");
    private final static QName _IsRoleAdmin_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "isRoleAdmin");
    private final static QName _IsRoleAdminResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "isRoleAdminResponse");
    private final static QName _LoadUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadUser");
    private final static QName _LoadUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadUserResponse");
    private final static QName _MergeUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "mergeUser");
    private final static QName _MergeUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "mergeUserResponse");
    private final static QName _PersistUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "persistUser");
    private final static QName _PersistUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "persistUserResponse");
    private final static QName _RemoveAllUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeAllUser");
    private final static QName _RemoveAllUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeAllUserResponse");
    private final static QName _RemoveUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeUser");
    private final static QName _RemoveUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeUserResponse");
    private final static QName _SetCurrentUser_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "setCurrentUser");
    private final static QName _SetCurrentUserResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "setCurrentUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.naumkin.tm.api.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link FindAllUsers }
     * 
     */
    public FindAllUsers createFindAllUsers() {
        return new FindAllUsers();
    }

    /**
     * Create an instance of {@link FindAllUsersResponse }
     * 
     */
    public FindAllUsersResponse createFindAllUsersResponse() {
        return new FindAllUsersResponse();
    }

    /**
     * Create an instance of {@link FindOneUser }
     * 
     */
    public FindOneUser createFindOneUser() {
        return new FindOneUser();
    }

    /**
     * Create an instance of {@link FindOneUserResponse }
     * 
     */
    public FindOneUserResponse createFindOneUserResponse() {
        return new FindOneUserResponse();
    }

    /**
     * Create an instance of {@link GetCurrentUser }
     * 
     */
    public GetCurrentUser createGetCurrentUser() {
        return new GetCurrentUser();
    }

    /**
     * Create an instance of {@link GetCurrentUserId }
     * 
     */
    public GetCurrentUserId createGetCurrentUserId() {
        return new GetCurrentUserId();
    }

    /**
     * Create an instance of {@link GetCurrentUserIdResponse }
     * 
     */
    public GetCurrentUserIdResponse createGetCurrentUserIdResponse() {
        return new GetCurrentUserIdResponse();
    }

    /**
     * Create an instance of {@link GetCurrentUserResponse }
     * 
     */
    public GetCurrentUserResponse createGetCurrentUserResponse() {
        return new GetCurrentUserResponse();
    }

    /**
     * Create an instance of {@link IsRoleAdmin }
     * 
     */
    public IsRoleAdmin createIsRoleAdmin() {
        return new IsRoleAdmin();
    }

    /**
     * Create an instance of {@link IsRoleAdminResponse }
     * 
     */
    public IsRoleAdminResponse createIsRoleAdminResponse() {
        return new IsRoleAdminResponse();
    }

    /**
     * Create an instance of {@link LoadUser }
     * 
     */
    public LoadUser createLoadUser() {
        return new LoadUser();
    }

    /**
     * Create an instance of {@link LoadUserResponse }
     * 
     */
    public LoadUserResponse createLoadUserResponse() {
        return new LoadUserResponse();
    }

    /**
     * Create an instance of {@link MergeUser }
     * 
     */
    public MergeUser createMergeUser() {
        return new MergeUser();
    }

    /**
     * Create an instance of {@link MergeUserResponse }
     * 
     */
    public MergeUserResponse createMergeUserResponse() {
        return new MergeUserResponse();
    }

    /**
     * Create an instance of {@link PersistUser }
     * 
     */
    public PersistUser createPersistUser() {
        return new PersistUser();
    }

    /**
     * Create an instance of {@link PersistUserResponse }
     * 
     */
    public PersistUserResponse createPersistUserResponse() {
        return new PersistUserResponse();
    }

    /**
     * Create an instance of {@link RemoveAllUser }
     * 
     */
    public RemoveAllUser createRemoveAllUser() {
        return new RemoveAllUser();
    }

    /**
     * Create an instance of {@link RemoveAllUserResponse }
     * 
     */
    public RemoveAllUserResponse createRemoveAllUserResponse() {
        return new RemoveAllUserResponse();
    }

    /**
     * Create an instance of {@link RemoveUser }
     * 
     */
    public RemoveUser createRemoveUser() {
        return new RemoveUser();
    }

    /**
     * Create an instance of {@link RemoveUserResponse }
     * 
     */
    public RemoveUserResponse createRemoveUserResponse() {
        return new RemoveUserResponse();
    }

    /**
     * Create an instance of {@link SetCurrentUser }
     * 
     */
    public SetCurrentUser createSetCurrentUser() {
        return new SetCurrentUser();
    }

    /**
     * Create an instance of {@link SetCurrentUserResponse }
     * 
     */
    public SetCurrentUserResponse createSetCurrentUserResponse() {
        return new SetCurrentUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUsers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllUsers }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findAllUsers")
    public JAXBElement<FindAllUsers> createFindAllUsers(FindAllUsers value) {
        return new JAXBElement<FindAllUsers>(_FindAllUsers_QNAME, FindAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUsersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllUsersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findAllUsersResponse")
    public JAXBElement<FindAllUsersResponse> createFindAllUsersResponse(FindAllUsersResponse value) {
        return new JAXBElement<FindAllUsersResponse>(_FindAllUsersResponse_QNAME, FindAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindOneUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findOneUser")
    public JAXBElement<FindOneUser> createFindOneUser(FindOneUser value) {
        return new JAXBElement<FindOneUser>(_FindOneUser_QNAME, FindOneUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindOneUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findOneUserResponse")
    public JAXBElement<FindOneUserResponse> createFindOneUserResponse(FindOneUserResponse value) {
        return new JAXBElement<FindOneUserResponse>(_FindOneUserResponse_QNAME, FindOneUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "getCurrentUser")
    public JAXBElement<GetCurrentUser> createGetCurrentUser(GetCurrentUser value) {
        return new JAXBElement<GetCurrentUser>(_GetCurrentUser_QNAME, GetCurrentUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUserId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentUserId }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "getCurrentUserId")
    public JAXBElement<GetCurrentUserId> createGetCurrentUserId(GetCurrentUserId value) {
        return new JAXBElement<GetCurrentUserId>(_GetCurrentUserId_QNAME, GetCurrentUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUserIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentUserIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "getCurrentUserIdResponse")
    public JAXBElement<GetCurrentUserIdResponse> createGetCurrentUserIdResponse(GetCurrentUserIdResponse value) {
        return new JAXBElement<GetCurrentUserIdResponse>(_GetCurrentUserIdResponse_QNAME, GetCurrentUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "getCurrentUserResponse")
    public JAXBElement<GetCurrentUserResponse> createGetCurrentUserResponse(GetCurrentUserResponse value) {
        return new JAXBElement<GetCurrentUserResponse>(_GetCurrentUserResponse_QNAME, GetCurrentUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsRoleAdmin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IsRoleAdmin }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "isRoleAdmin")
    public JAXBElement<IsRoleAdmin> createIsRoleAdmin(IsRoleAdmin value) {
        return new JAXBElement<IsRoleAdmin>(_IsRoleAdmin_QNAME, IsRoleAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsRoleAdminResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IsRoleAdminResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "isRoleAdminResponse")
    public JAXBElement<IsRoleAdminResponse> createIsRoleAdminResponse(IsRoleAdminResponse value) {
        return new JAXBElement<IsRoleAdminResponse>(_IsRoleAdminResponse_QNAME, IsRoleAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadUser")
    public JAXBElement<LoadUser> createLoadUser(LoadUser value) {
        return new JAXBElement<LoadUser>(_LoadUser_QNAME, LoadUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadUserResponse")
    public JAXBElement<LoadUserResponse> createLoadUserResponse(LoadUserResponse value) {
        return new JAXBElement<LoadUserResponse>(_LoadUserResponse_QNAME, LoadUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MergeUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "mergeUser")
    public JAXBElement<MergeUser> createMergeUser(MergeUser value) {
        return new JAXBElement<MergeUser>(_MergeUser_QNAME, MergeUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MergeUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "mergeUserResponse")
    public JAXBElement<MergeUserResponse> createMergeUserResponse(MergeUserResponse value) {
        return new JAXBElement<MergeUserResponse>(_MergeUserResponse_QNAME, MergeUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersistUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "persistUser")
    public JAXBElement<PersistUser> createPersistUser(PersistUser value) {
        return new JAXBElement<PersistUser>(_PersistUser_QNAME, PersistUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersistUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "persistUserResponse")
    public JAXBElement<PersistUserResponse> createPersistUserResponse(PersistUserResponse value) {
        return new JAXBElement<PersistUserResponse>(_PersistUserResponse_QNAME, PersistUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAllUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAllUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeAllUser")
    public JAXBElement<RemoveAllUser> createRemoveAllUser(RemoveAllUser value) {
        return new JAXBElement<RemoveAllUser>(_RemoveAllUser_QNAME, RemoveAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAllUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAllUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeAllUserResponse")
    public JAXBElement<RemoveAllUserResponse> createRemoveAllUserResponse(RemoveAllUserResponse value) {
        return new JAXBElement<RemoveAllUserResponse>(_RemoveAllUserResponse_QNAME, RemoveAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeUser")
    public JAXBElement<RemoveUser> createRemoveUser(RemoveUser value) {
        return new JAXBElement<RemoveUser>(_RemoveUser_QNAME, RemoveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeUserResponse")
    public JAXBElement<RemoveUserResponse> createRemoveUserResponse(RemoveUserResponse value) {
        return new JAXBElement<RemoveUserResponse>(_RemoveUserResponse_QNAME, RemoveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCurrentUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetCurrentUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "setCurrentUser")
    public JAXBElement<SetCurrentUser> createSetCurrentUser(SetCurrentUser value) {
        return new JAXBElement<SetCurrentUser>(_SetCurrentUser_QNAME, SetCurrentUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCurrentUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetCurrentUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "setCurrentUserResponse")
    public JAXBElement<SetCurrentUserResponse> createSetCurrentUserResponse(SetCurrentUserResponse value) {
        return new JAXBElement<SetCurrentUserResponse>(_SetCurrentUserResponse_QNAME, SetCurrentUserResponse.class, null, value);
    }

}
