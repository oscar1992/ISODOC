
package co.com.siscomputo.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Administacion", targetNamespace = "http://endpoint.siscomputo.com.co/", wsdlLocation = "http://localhost:8084/ISODOCWS/Administacion?wsdl")
public class Administacion_Service
    extends Service
{

    private final static URL ADMINISTACION_WSDL_LOCATION;
    private final static WebServiceException ADMINISTACION_EXCEPTION;
    private final static QName ADMINISTACION_QNAME = new QName("http://endpoint.siscomputo.com.co/", "Administacion");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8084/ISODOCWS/Administacion?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADMINISTACION_WSDL_LOCATION = url;
        ADMINISTACION_EXCEPTION = e;
    }

    public Administacion_Service() {
        super(__getWsdlLocation(), ADMINISTACION_QNAME);
    }

    public Administacion_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADMINISTACION_QNAME, features);
    }

    public Administacion_Service(URL wsdlLocation) {
        super(wsdlLocation, ADMINISTACION_QNAME);
    }

    public Administacion_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADMINISTACION_QNAME, features);
    }

    public Administacion_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Administacion_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Administacion
     */
    @WebEndpoint(name = "AdministacionPort")
    public Administacion getAdministacionPort() {
        return super.getPort(new QName("http://endpoint.siscomputo.com.co/", "AdministacionPort"), Administacion.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Administacion
     */
    @WebEndpoint(name = "AdministacionPort")
    public Administacion getAdministacionPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.siscomputo.com.co/", "AdministacionPort"), Administacion.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADMINISTACION_EXCEPTION!= null) {
            throw ADMINISTACION_EXCEPTION;
        }
        return ADMINISTACION_WSDL_LOCATION;
    }

}
