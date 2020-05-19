package ru.naumkin.tm.enpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-19T22:24:56.920+07:00
 * Generated source version: 3.3.6
 *
 */
@WebServiceClient(name = "TaskEndpointService",
                  wsdlLocation = "http://localhost:8080/TaskEndpoint?wsdl",
                  targetNamespace = "http://enpoint.tm.naumkin.ru/")
public class TaskEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://enpoint.tm.naumkin.ru/", "TaskEndpointService");
    public final static QName TaskEndpointPort = new QName("http://enpoint.tm.naumkin.ru/", "TaskEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/TaskEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TaskEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/TaskEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TaskEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TaskEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TaskEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TaskEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ITaskEndpoint
     */
    @WebEndpoint(name = "TaskEndpointPort")
    public ITaskEndpoint getTaskEndpointPort() {
        return super.getPort(TaskEndpointPort, ITaskEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITaskEndpoint
     */
    @WebEndpoint(name = "TaskEndpointPort")
    public ITaskEndpoint getTaskEndpointPort(WebServiceFeature... features) {
        return super.getPort(TaskEndpointPort, ITaskEndpoint.class, features);
    }

}
