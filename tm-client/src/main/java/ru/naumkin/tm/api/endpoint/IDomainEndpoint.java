package ru.naumkin.tm.api.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-22T19:57:41.129+07:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://endpoint.api.tm.naumkin.ru/", name = "IDomainEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface IDomainEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataFasterXmlRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataFasterXmlResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataFasterXml/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataFasterXml/Fault/SQLException")})
    @RequestWrapper(localName = "loadJsonDataFasterXml", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadJsonDataFasterXml")
    @ResponseWrapper(localName = "loadJsonDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadJsonDataFasterXmlResponse")
    public void loadJsonDataFasterXml(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveBinaryDataRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveBinaryDataResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveBinaryData/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveBinaryData/Fault/SQLException")})
    @RequestWrapper(localName = "saveBinaryData", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveBinaryData")
    @ResponseWrapper(localName = "saveBinaryDataResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveBinaryDataResponse")
    public void saveBinaryData(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataFasterXmlRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataFasterXmlResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataFasterXml/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataFasterXml/Fault/SQLException")})
    @RequestWrapper(localName = "saveJsonDataFasterXml", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveJsonDataFasterXml")
    @ResponseWrapper(localName = "saveJsonDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveJsonDataFasterXmlResponse")
    public void saveJsonDataFasterXml(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataJaxbRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataJaxbResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataJaxb/Fault/IOException"), @FaultAction(className = JAXBException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataJaxb/Fault/JAXBException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveJsonDataJaxb/Fault/SQLException")})
    @RequestWrapper(localName = "saveJsonDataJaxb", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveJsonDataJaxb")
    @ResponseWrapper(localName = "saveJsonDataJaxbResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveJsonDataJaxbResponse")
    public void saveJsonDataJaxb(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, JAXBException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataFasterXmlRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataFasterXmlResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataFasterXml/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataFasterXml/Fault/SQLException")})
    @RequestWrapper(localName = "loadXmlDataFasterXml", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadXmlDataFasterXml")
    @ResponseWrapper(localName = "loadXmlDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadXmlDataFasterXmlResponse")
    public void loadXmlDataFasterXml(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadResponse", fault = {@FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/load/Fault/SQLException")})
    @RequestWrapper(localName = "load", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.Load")
    @ResponseWrapper(localName = "loadResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.naumkin.tm.api.endpoint.Domain load()
 throws SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataJaxbRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataJaxbResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataJaxb/Fault/IOException"), @FaultAction(className = JAXBException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataJaxb/Fault/JAXBException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadJsonDataJaxb/Fault/SQLException")})
    @RequestWrapper(localName = "loadJsonDataJaxb", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadJsonDataJaxb")
    @ResponseWrapper(localName = "loadJsonDataJaxbResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadJsonDataJaxbResponse")
    public void loadJsonDataJaxb(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, JAXBException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataJaxbRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataJaxbResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataJaxb/Fault/IOException"), @FaultAction(className = JAXBException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataJaxb/Fault/JAXBException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataJaxb/Fault/SQLException")})
    @RequestWrapper(localName = "saveXmlDataJaxb", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveXmlDataJaxb")
    @ResponseWrapper(localName = "saveXmlDataJaxbResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveXmlDataJaxbResponse")
    public void saveXmlDataJaxb(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, JAXBException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveResponse", fault = {@FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/save/Fault/SQLException")})
    @RequestWrapper(localName = "save", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveResponse")
    public void save(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Domain arg0
    ) throws SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataFasterXmlRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataFasterXmlResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataFasterXml/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/saveXmlDataFasterXml/Fault/SQLException")})
    @RequestWrapper(localName = "saveXmlDataFasterXml", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveXmlDataFasterXml")
    @ResponseWrapper(localName = "saveXmlDataFasterXmlResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.SaveXmlDataFasterXmlResponse")
    public void saveXmlDataFasterXml(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataJaxbRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataJaxbResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataJaxb/Fault/IOException"), @FaultAction(className = JAXBException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataJaxb/Fault/JAXBException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadXmlDataJaxb/Fault/SQLException")})
    @RequestWrapper(localName = "loadXmlDataJaxb", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadXmlDataJaxb")
    @ResponseWrapper(localName = "loadXmlDataJaxbResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadXmlDataJaxbResponse")
    public void loadXmlDataJaxb(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, JAXBException, SQLException;

    @WebMethod
    @Action(input = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadBinaryDataRequest", output = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadBinaryDataResponse", fault = {@FaultAction(className = IOException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadBinaryData/Fault/IOException"), @FaultAction(className = SQLException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadBinaryData/Fault/SQLException"), @FaultAction(className = ClassNotFoundException.class, value = "http://endpoint.api.tm.naumkin.ru/IDomainEndpoint/loadBinaryData/Fault/ClassNotFoundException")})
    @RequestWrapper(localName = "loadBinaryData", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadBinaryData")
    @ResponseWrapper(localName = "loadBinaryDataResponse", targetNamespace = "http://endpoint.api.tm.naumkin.ru/", className = "ru.naumkin.tm.api.endpoint.LoadBinaryDataResponse")
    public void loadBinaryData(

        @WebParam(name = "arg0", targetNamespace = "")
        ru.naumkin.tm.api.endpoint.Session arg0
    ) throws IOException, SQLException, ClassNotFoundException;
}
