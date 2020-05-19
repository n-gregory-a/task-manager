
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
    private final static QName _Domain_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "domain");
    private final static QName _Load_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "load");
    private final static QName _LoadBinaryData_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadBinaryData");
    private final static QName _LoadBinaryDataResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadBinaryDataResponse");
    private final static QName _LoadJsonDataFasterXml_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadJsonDataFasterXml");
    private final static QName _LoadJsonDataFasterXmlResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadJsonDataFasterXmlResponse");
    private final static QName _LoadJsonDataJaxb_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadJsonDataJaxb");
    private final static QName _LoadJsonDataJaxbResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadJsonDataJaxbResponse");
    private final static QName _LoadResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadResponse");
    private final static QName _LoadXmlDataFasterXml_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadXmlDataFasterXml");
    private final static QName _LoadXmlDataFasterXmlResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadXmlDataFasterXmlResponse");
    private final static QName _LoadXmlDataJaxb_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadXmlDataJaxb");
    private final static QName _LoadXmlDataJaxbResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "loadXmlDataJaxbResponse");
    private final static QName _Save_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "save");
    private final static QName _SaveBinaryData_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveBinaryData");
    private final static QName _SaveBinaryDataResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveBinaryDataResponse");
    private final static QName _SaveJsonDataFasterXml_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveJsonDataFasterXml");
    private final static QName _SaveJsonDataFasterXmlResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveJsonDataFasterXmlResponse");
    private final static QName _SaveJsonDataJaxb_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveJsonDataJaxb");
    private final static QName _SaveJsonDataJaxbResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveJsonDataJaxbResponse");
    private final static QName _SaveResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveResponse");
    private final static QName _SaveXmlDataFasterXml_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveXmlDataFasterXml");
    private final static QName _SaveXmlDataFasterXmlResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveXmlDataFasterXmlResponse");
    private final static QName _SaveXmlDataJaxb_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveXmlDataJaxb");
    private final static QName _SaveXmlDataJaxbResponse_QNAME = new QName("http://endpoint.api.tm.naumkin.ru/", "saveXmlDataJaxbResponse");

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
     * Create an instance of {@link Domain }
     * 
     */
    public Domain createDomain() {
        return new Domain();
    }

    /**
     * Create an instance of {@link Load }
     * 
     */
    public Load createLoad() {
        return new Load();
    }

    /**
     * Create an instance of {@link LoadBinaryData }
     * 
     */
    public LoadBinaryData createLoadBinaryData() {
        return new LoadBinaryData();
    }

    /**
     * Create an instance of {@link LoadBinaryDataResponse }
     * 
     */
    public LoadBinaryDataResponse createLoadBinaryDataResponse() {
        return new LoadBinaryDataResponse();
    }

    /**
     * Create an instance of {@link LoadJsonDataFasterXml }
     * 
     */
    public LoadJsonDataFasterXml createLoadJsonDataFasterXml() {
        return new LoadJsonDataFasterXml();
    }

    /**
     * Create an instance of {@link LoadJsonDataFasterXmlResponse }
     * 
     */
    public LoadJsonDataFasterXmlResponse createLoadJsonDataFasterXmlResponse() {
        return new LoadJsonDataFasterXmlResponse();
    }

    /**
     * Create an instance of {@link LoadJsonDataJaxb }
     * 
     */
    public LoadJsonDataJaxb createLoadJsonDataJaxb() {
        return new LoadJsonDataJaxb();
    }

    /**
     * Create an instance of {@link LoadJsonDataJaxbResponse }
     * 
     */
    public LoadJsonDataJaxbResponse createLoadJsonDataJaxbResponse() {
        return new LoadJsonDataJaxbResponse();
    }

    /**
     * Create an instance of {@link LoadResponse }
     * 
     */
    public LoadResponse createLoadResponse() {
        return new LoadResponse();
    }

    /**
     * Create an instance of {@link LoadXmlDataFasterXml }
     * 
     */
    public LoadXmlDataFasterXml createLoadXmlDataFasterXml() {
        return new LoadXmlDataFasterXml();
    }

    /**
     * Create an instance of {@link LoadXmlDataFasterXmlResponse }
     * 
     */
    public LoadXmlDataFasterXmlResponse createLoadXmlDataFasterXmlResponse() {
        return new LoadXmlDataFasterXmlResponse();
    }

    /**
     * Create an instance of {@link LoadXmlDataJaxb }
     * 
     */
    public LoadXmlDataJaxb createLoadXmlDataJaxb() {
        return new LoadXmlDataJaxb();
    }

    /**
     * Create an instance of {@link LoadXmlDataJaxbResponse }
     * 
     */
    public LoadXmlDataJaxbResponse createLoadXmlDataJaxbResponse() {
        return new LoadXmlDataJaxbResponse();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link SaveBinaryData }
     * 
     */
    public SaveBinaryData createSaveBinaryData() {
        return new SaveBinaryData();
    }

    /**
     * Create an instance of {@link SaveBinaryDataResponse }
     * 
     */
    public SaveBinaryDataResponse createSaveBinaryDataResponse() {
        return new SaveBinaryDataResponse();
    }

    /**
     * Create an instance of {@link SaveJsonDataFasterXml }
     * 
     */
    public SaveJsonDataFasterXml createSaveJsonDataFasterXml() {
        return new SaveJsonDataFasterXml();
    }

    /**
     * Create an instance of {@link SaveJsonDataFasterXmlResponse }
     * 
     */
    public SaveJsonDataFasterXmlResponse createSaveJsonDataFasterXmlResponse() {
        return new SaveJsonDataFasterXmlResponse();
    }

    /**
     * Create an instance of {@link SaveJsonDataJaxb }
     * 
     */
    public SaveJsonDataJaxb createSaveJsonDataJaxb() {
        return new SaveJsonDataJaxb();
    }

    /**
     * Create an instance of {@link SaveJsonDataJaxbResponse }
     * 
     */
    public SaveJsonDataJaxbResponse createSaveJsonDataJaxbResponse() {
        return new SaveJsonDataJaxbResponse();
    }

    /**
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
    }

    /**
     * Create an instance of {@link SaveXmlDataFasterXml }
     * 
     */
    public SaveXmlDataFasterXml createSaveXmlDataFasterXml() {
        return new SaveXmlDataFasterXml();
    }

    /**
     * Create an instance of {@link SaveXmlDataFasterXmlResponse }
     * 
     */
    public SaveXmlDataFasterXmlResponse createSaveXmlDataFasterXmlResponse() {
        return new SaveXmlDataFasterXmlResponse();
    }

    /**
     * Create an instance of {@link SaveXmlDataJaxb }
     * 
     */
    public SaveXmlDataJaxb createSaveXmlDataJaxb() {
        return new SaveXmlDataJaxb();
    }

    /**
     * Create an instance of {@link SaveXmlDataJaxbResponse }
     * 
     */
    public SaveXmlDataJaxbResponse createSaveXmlDataJaxbResponse() {
        return new SaveXmlDataJaxbResponse();
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Domain }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Domain }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "domain")
    public JAXBElement<Domain> createDomain(Domain value) {
        return new JAXBElement<Domain>(_Domain_QNAME, Domain.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Load }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Load }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "load")
    public JAXBElement<Load> createLoad(Load value) {
        return new JAXBElement<Load>(_Load_QNAME, Load.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBinaryData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadBinaryData }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadBinaryData")
    public JAXBElement<LoadBinaryData> createLoadBinaryData(LoadBinaryData value) {
        return new JAXBElement<LoadBinaryData>(_LoadBinaryData_QNAME, LoadBinaryData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBinaryDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadBinaryDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadBinaryDataResponse")
    public JAXBElement<LoadBinaryDataResponse> createLoadBinaryDataResponse(LoadBinaryDataResponse value) {
        return new JAXBElement<LoadBinaryDataResponse>(_LoadBinaryDataResponse_QNAME, LoadBinaryDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonDataFasterXml }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadJsonDataFasterXml }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadJsonDataFasterXml")
    public JAXBElement<LoadJsonDataFasterXml> createLoadJsonDataFasterXml(LoadJsonDataFasterXml value) {
        return new JAXBElement<LoadJsonDataFasterXml>(_LoadJsonDataFasterXml_QNAME, LoadJsonDataFasterXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonDataFasterXmlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadJsonDataFasterXmlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadJsonDataFasterXmlResponse")
    public JAXBElement<LoadJsonDataFasterXmlResponse> createLoadJsonDataFasterXmlResponse(LoadJsonDataFasterXmlResponse value) {
        return new JAXBElement<LoadJsonDataFasterXmlResponse>(_LoadJsonDataFasterXmlResponse_QNAME, LoadJsonDataFasterXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonDataJaxb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadJsonDataJaxb }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadJsonDataJaxb")
    public JAXBElement<LoadJsonDataJaxb> createLoadJsonDataJaxb(LoadJsonDataJaxb value) {
        return new JAXBElement<LoadJsonDataJaxb>(_LoadJsonDataJaxb_QNAME, LoadJsonDataJaxb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonDataJaxbResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadJsonDataJaxbResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadJsonDataJaxbResponse")
    public JAXBElement<LoadJsonDataJaxbResponse> createLoadJsonDataJaxbResponse(LoadJsonDataJaxbResponse value) {
        return new JAXBElement<LoadJsonDataJaxbResponse>(_LoadJsonDataJaxbResponse_QNAME, LoadJsonDataJaxbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadResponse")
    public JAXBElement<LoadResponse> createLoadResponse(LoadResponse value) {
        return new JAXBElement<LoadResponse>(_LoadResponse_QNAME, LoadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXmlDataFasterXml }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadXmlDataFasterXml }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadXmlDataFasterXml")
    public JAXBElement<LoadXmlDataFasterXml> createLoadXmlDataFasterXml(LoadXmlDataFasterXml value) {
        return new JAXBElement<LoadXmlDataFasterXml>(_LoadXmlDataFasterXml_QNAME, LoadXmlDataFasterXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXmlDataFasterXmlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadXmlDataFasterXmlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadXmlDataFasterXmlResponse")
    public JAXBElement<LoadXmlDataFasterXmlResponse> createLoadXmlDataFasterXmlResponse(LoadXmlDataFasterXmlResponse value) {
        return new JAXBElement<LoadXmlDataFasterXmlResponse>(_LoadXmlDataFasterXmlResponse_QNAME, LoadXmlDataFasterXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXmlDataJaxb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadXmlDataJaxb }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadXmlDataJaxb")
    public JAXBElement<LoadXmlDataJaxb> createLoadXmlDataJaxb(LoadXmlDataJaxb value) {
        return new JAXBElement<LoadXmlDataJaxb>(_LoadXmlDataJaxb_QNAME, LoadXmlDataJaxb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXmlDataJaxbResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoadXmlDataJaxbResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "loadXmlDataJaxbResponse")
    public JAXBElement<LoadXmlDataJaxbResponse> createLoadXmlDataJaxbResponse(LoadXmlDataJaxbResponse value) {
        return new JAXBElement<LoadXmlDataJaxbResponse>(_LoadXmlDataJaxbResponse_QNAME, LoadXmlDataJaxbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Save }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBinaryData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveBinaryData }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveBinaryData")
    public JAXBElement<SaveBinaryData> createSaveBinaryData(SaveBinaryData value) {
        return new JAXBElement<SaveBinaryData>(_SaveBinaryData_QNAME, SaveBinaryData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBinaryDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveBinaryDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveBinaryDataResponse")
    public JAXBElement<SaveBinaryDataResponse> createSaveBinaryDataResponse(SaveBinaryDataResponse value) {
        return new JAXBElement<SaveBinaryDataResponse>(_SaveBinaryDataResponse_QNAME, SaveBinaryDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonDataFasterXml }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveJsonDataFasterXml }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveJsonDataFasterXml")
    public JAXBElement<SaveJsonDataFasterXml> createSaveJsonDataFasterXml(SaveJsonDataFasterXml value) {
        return new JAXBElement<SaveJsonDataFasterXml>(_SaveJsonDataFasterXml_QNAME, SaveJsonDataFasterXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonDataFasterXmlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveJsonDataFasterXmlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveJsonDataFasterXmlResponse")
    public JAXBElement<SaveJsonDataFasterXmlResponse> createSaveJsonDataFasterXmlResponse(SaveJsonDataFasterXmlResponse value) {
        return new JAXBElement<SaveJsonDataFasterXmlResponse>(_SaveJsonDataFasterXmlResponse_QNAME, SaveJsonDataFasterXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonDataJaxb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveJsonDataJaxb }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveJsonDataJaxb")
    public JAXBElement<SaveJsonDataJaxb> createSaveJsonDataJaxb(SaveJsonDataJaxb value) {
        return new JAXBElement<SaveJsonDataJaxb>(_SaveJsonDataJaxb_QNAME, SaveJsonDataJaxb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonDataJaxbResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveJsonDataJaxbResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveJsonDataJaxbResponse")
    public JAXBElement<SaveJsonDataJaxbResponse> createSaveJsonDataJaxbResponse(SaveJsonDataJaxbResponse value) {
        return new JAXBElement<SaveJsonDataJaxbResponse>(_SaveJsonDataJaxbResponse_QNAME, SaveJsonDataJaxbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXmlDataFasterXml }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveXmlDataFasterXml }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveXmlDataFasterXml")
    public JAXBElement<SaveXmlDataFasterXml> createSaveXmlDataFasterXml(SaveXmlDataFasterXml value) {
        return new JAXBElement<SaveXmlDataFasterXml>(_SaveXmlDataFasterXml_QNAME, SaveXmlDataFasterXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXmlDataFasterXmlResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveXmlDataFasterXmlResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveXmlDataFasterXmlResponse")
    public JAXBElement<SaveXmlDataFasterXmlResponse> createSaveXmlDataFasterXmlResponse(SaveXmlDataFasterXmlResponse value) {
        return new JAXBElement<SaveXmlDataFasterXmlResponse>(_SaveXmlDataFasterXmlResponse_QNAME, SaveXmlDataFasterXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXmlDataJaxb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveXmlDataJaxb }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveXmlDataJaxb")
    public JAXBElement<SaveXmlDataJaxb> createSaveXmlDataJaxb(SaveXmlDataJaxb value) {
        return new JAXBElement<SaveXmlDataJaxb>(_SaveXmlDataJaxb_QNAME, SaveXmlDataJaxb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXmlDataJaxbResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveXmlDataJaxbResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.api.tm.naumkin.ru/", name = "saveXmlDataJaxbResponse")
    public JAXBElement<SaveXmlDataJaxbResponse> createSaveXmlDataJaxbResponse(SaveXmlDataJaxbResponse value) {
        return new JAXBElement<SaveXmlDataJaxbResponse>(_SaveXmlDataJaxbResponse_QNAME, SaveXmlDataJaxbResponse.class, null, value);
    }

}
