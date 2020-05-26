
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

    private final static QName _Exception_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "Exception");
    private final static QName _FindAllSessions_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findAllSessions");
    private final static QName _FindAllSessionsResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findAllSessionsResponse");
    private final static QName _FindOneSession_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findOneSession");
    private final static QName _FindOneSessionResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "findOneSessionResponse");
    private final static QName _MergeSession_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "mergeSession");
    private final static QName _MergeSessionResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "mergeSessionResponse");
    private final static QName _Open_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "open");
    private final static QName _OpenResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "openResponse");
    private final static QName _PersistSession_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "persistSession");
    private final static QName _PersistSessionResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "persistSessionResponse");
    private final static QName _RemoveAllSessions_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeAllSessions");
    private final static QName _RemoveAllSessionsResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeAllSessionsResponse");
    private final static QName _RemoveSession_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeSession");
    private final static QName _RemoveSessionResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "removeSessionResponse");
    private final static QName _Sign_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "sign");
    private final static QName _SignResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "signResponse");
    private final static QName _Validate_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "validate");
    private final static QName _ValidateResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "validateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.naumkin.tm.api.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link FindAllSessions }
     * 
     */
    public FindAllSessions createFindAllSessions() {
        return new FindAllSessions();
    }

    /**
     * Create an instance of {@link FindAllSessionsResponse }
     * 
     */
    public FindAllSessionsResponse createFindAllSessionsResponse() {
        return new FindAllSessionsResponse();
    }

    /**
     * Create an instance of {@link FindOneSession }
     * 
     */
    public FindOneSession createFindOneSession() {
        return new FindOneSession();
    }

    /**
     * Create an instance of {@link FindOneSessionResponse }
     * 
     */
    public FindOneSessionResponse createFindOneSessionResponse() {
        return new FindOneSessionResponse();
    }

    /**
     * Create an instance of {@link MergeSession }
     * 
     */
    public MergeSession createMergeSession() {
        return new MergeSession();
    }

    /**
     * Create an instance of {@link MergeSessionResponse }
     * 
     */
    public MergeSessionResponse createMergeSessionResponse() {
        return new MergeSessionResponse();
    }

    /**
     * Create an instance of {@link Open }
     * 
     */
    public Open createOpen() {
        return new Open();
    }

    /**
     * Create an instance of {@link OpenResponse }
     * 
     */
    public OpenResponse createOpenResponse() {
        return new OpenResponse();
    }

    /**
     * Create an instance of {@link PersistSession }
     * 
     */
    public PersistSession createPersistSession() {
        return new PersistSession();
    }

    /**
     * Create an instance of {@link PersistSessionResponse }
     * 
     */
    public PersistSessionResponse createPersistSessionResponse() {
        return new PersistSessionResponse();
    }

    /**
     * Create an instance of {@link RemoveAllSessions }
     * 
     */
    public RemoveAllSessions createRemoveAllSessions() {
        return new RemoveAllSessions();
    }

    /**
     * Create an instance of {@link RemoveAllSessionsResponse }
     * 
     */
    public RemoveAllSessionsResponse createRemoveAllSessionsResponse() {
        return new RemoveAllSessionsResponse();
    }

    /**
     * Create an instance of {@link RemoveSession }
     * 
     */
    public RemoveSession createRemoveSession() {
        return new RemoveSession();
    }

    /**
     * Create an instance of {@link RemoveSessionResponse }
     * 
     */
    public RemoveSessionResponse createRemoveSessionResponse() {
        return new RemoveSessionResponse();
    }

    /**
     * Create an instance of {@link Sign }
     * 
     */
    public Sign createSign() {
        return new Sign();
    }

    /**
     * Create an instance of {@link SignResponse }
     * 
     */
    public SignResponse createSignResponse() {
        return new SignResponse();
    }

    /**
     * Create an instance of {@link Validate }
     * 
     */
    public Validate createValidate() {
        return new Validate();
    }

    /**
     * Create an instance of {@link ValidateResponse }
     * 
     */
    public ValidateResponse createValidateResponse() {
        return new ValidateResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSessions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllSessions }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findAllSessions")
    public JAXBElement<FindAllSessions> createFindAllSessions(FindAllSessions value) {
        return new JAXBElement<FindAllSessions>(_FindAllSessions_QNAME, FindAllSessions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllSessionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllSessionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findAllSessionsResponse")
    public JAXBElement<FindAllSessionsResponse> createFindAllSessionsResponse(FindAllSessionsResponse value) {
        return new JAXBElement<FindAllSessionsResponse>(_FindAllSessionsResponse_QNAME, FindAllSessionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindOneSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findOneSession")
    public JAXBElement<FindOneSession> createFindOneSession(FindOneSession value) {
        return new JAXBElement<FindOneSession>(_FindOneSession_QNAME, FindOneSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindOneSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "findOneSessionResponse")
    public JAXBElement<FindOneSessionResponse> createFindOneSessionResponse(FindOneSessionResponse value) {
        return new JAXBElement<FindOneSessionResponse>(_FindOneSessionResponse_QNAME, FindOneSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MergeSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "mergeSession")
    public JAXBElement<MergeSession> createMergeSession(MergeSession value) {
        return new JAXBElement<MergeSession>(_MergeSession_QNAME, MergeSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MergeSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "mergeSessionResponse")
    public JAXBElement<MergeSessionResponse> createMergeSessionResponse(MergeSessionResponse value) {
        return new JAXBElement<MergeSessionResponse>(_MergeSessionResponse_QNAME, MergeSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Open }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Open }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "open")
    public JAXBElement<Open> createOpen(Open value) {
        return new JAXBElement<Open>(_Open_QNAME, Open.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OpenResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "openResponse")
    public JAXBElement<OpenResponse> createOpenResponse(OpenResponse value) {
        return new JAXBElement<OpenResponse>(_OpenResponse_QNAME, OpenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersistSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "persistSession")
    public JAXBElement<PersistSession> createPersistSession(PersistSession value) {
        return new JAXBElement<PersistSession>(_PersistSession_QNAME, PersistSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersistSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "persistSessionResponse")
    public JAXBElement<PersistSessionResponse> createPersistSessionResponse(PersistSessionResponse value) {
        return new JAXBElement<PersistSessionResponse>(_PersistSessionResponse_QNAME, PersistSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAllSessions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAllSessions }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeAllSessions")
    public JAXBElement<RemoveAllSessions> createRemoveAllSessions(RemoveAllSessions value) {
        return new JAXBElement<RemoveAllSessions>(_RemoveAllSessions_QNAME, RemoveAllSessions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAllSessionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAllSessionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeAllSessionsResponse")
    public JAXBElement<RemoveAllSessionsResponse> createRemoveAllSessionsResponse(RemoveAllSessionsResponse value) {
        return new JAXBElement<RemoveAllSessionsResponse>(_RemoveAllSessionsResponse_QNAME, RemoveAllSessionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSession }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSession }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeSession")
    public JAXBElement<RemoveSession> createRemoveSession(RemoveSession value) {
        return new JAXBElement<RemoveSession>(_RemoveSession_QNAME, RemoveSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSessionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSessionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "removeSessionResponse")
    public JAXBElement<RemoveSessionResponse> createRemoveSessionResponse(RemoveSessionResponse value) {
        return new JAXBElement<RemoveSessionResponse>(_RemoveSessionResponse_QNAME, RemoveSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sign }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Sign }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "sign")
    public JAXBElement<Sign> createSign(Sign value) {
        return new JAXBElement<Sign>(_Sign_QNAME, Sign.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SignResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "signResponse")
    public JAXBElement<SignResponse> createSignResponse(SignResponse value) {
        return new JAXBElement<SignResponse>(_SignResponse_QNAME, SignResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Validate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Validate }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "validate")
    public JAXBElement<Validate> createValidate(Validate value) {
        return new JAXBElement<Validate>(_Validate_QNAME, Validate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "validateResponse")
    public JAXBElement<ValidateResponse> createValidateResponse(ValidateResponse value) {
        return new JAXBElement<ValidateResponse>(_ValidateResponse_QNAME, ValidateResponse.class, null, value);
    }

}
