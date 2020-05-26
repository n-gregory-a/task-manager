package ru.naumkin.tm.enpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.naumkin.tm.api.endpoint.IDomainEndpoint;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-26T19:59:12.908+07:00
 * Generated source version: 3.3.6
 *
 */
@WebServiceClient(name = "DomainEndpointService",
                  wsdlLocation = "http://localhost:8080/DomainEndpoint?wsdl",
                  targetNamespace = "http://enpoint.tm.naumkin.ru/")
public class DomainEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://enpoint.tm.naumkin.ru/", "DomainEndpointService");
    public final static QName DomainEndpointPort = new QName("http://enpoint.tm.naumkin.ru/", "DomainEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/DomainEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DomainEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/DomainEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DomainEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DomainEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DomainEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public DomainEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DomainEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DomainEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IDomainEndpoint
     */
    @WebEndpoint(name = "DomainEndpointPort")
    public IDomainEndpoint getDomainEndpointPort() {
        return super.getPort(DomainEndpointPort, IDomainEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDomainEndpoint
     */
    @WebEndpoint(name = "DomainEndpointPort")
    public IDomainEndpoint getDomainEndpointPort(WebServiceFeature... features) {
        return super.getPort(DomainEndpointPort, IDomainEndpoint.class, features);
    }

}
