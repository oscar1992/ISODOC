
package co.com.siscomputo.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.siscomputo.endpoint package. 
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

    private final static QName _InsertarLineaResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarLineaResponse");
    private final static QName _ActualizarLineaResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarLineaResponse");
    private final static QName _ListaLinea_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaLinea");
    private final static QName _ActualizarLinea_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarLinea");
    private final static QName _InsertarLinea_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarLinea");
    private final static QName _ListaLineaResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaLineaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.siscomputo.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarLineaResponse }
     * 
     */
    public InsertarLineaResponse createInsertarLineaResponse() {
        return new InsertarLineaResponse();
    }

    /**
     * Create an instance of {@link ActualizarLineaResponse }
     * 
     */
    public ActualizarLineaResponse createActualizarLineaResponse() {
        return new ActualizarLineaResponse();
    }

    /**
     * Create an instance of {@link ListaLinea }
     * 
     */
    public ListaLinea createListaLinea() {
        return new ListaLinea();
    }

    /**
     * Create an instance of {@link ActualizarLinea }
     * 
     */
    public ActualizarLinea createActualizarLinea() {
        return new ActualizarLinea();
    }

    /**
     * Create an instance of {@link InsertarLinea }
     * 
     */
    public InsertarLinea createInsertarLinea() {
        return new InsertarLinea();
    }

    /**
     * Create an instance of {@link ListaLineaResponse }
     * 
     */
    public ListaLineaResponse createListaLineaResponse() {
        return new ListaLineaResponse();
    }

    /**
     * Create an instance of {@link ObjetoRetornaEntity }
     * 
     */
    public ObjetoRetornaEntity createObjetoRetornaEntity() {
        return new ObjetoRetornaEntity();
    }

    /**
     * Create an instance of {@link ObjetoTraza }
     * 
     */
    public ObjetoTraza createObjetoTraza() {
        return new ObjetoTraza();
    }

    /**
     * Create an instance of {@link LineaEntity }
     * 
     */
    public LineaEntity createLineaEntity() {
        return new LineaEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarLineaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarLineaResponse")
    public JAXBElement<InsertarLineaResponse> createInsertarLineaResponse(InsertarLineaResponse value) {
        return new JAXBElement<InsertarLineaResponse>(_InsertarLineaResponse_QNAME, InsertarLineaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarLineaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarLineaResponse")
    public JAXBElement<ActualizarLineaResponse> createActualizarLineaResponse(ActualizarLineaResponse value) {
        return new JAXBElement<ActualizarLineaResponse>(_ActualizarLineaResponse_QNAME, ActualizarLineaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaLinea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaLinea")
    public JAXBElement<ListaLinea> createListaLinea(ListaLinea value) {
        return new JAXBElement<ListaLinea>(_ListaLinea_QNAME, ListaLinea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarLinea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarLinea")
    public JAXBElement<ActualizarLinea> createActualizarLinea(ActualizarLinea value) {
        return new JAXBElement<ActualizarLinea>(_ActualizarLinea_QNAME, ActualizarLinea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarLinea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarLinea")
    public JAXBElement<InsertarLinea> createInsertarLinea(InsertarLinea value) {
        return new JAXBElement<InsertarLinea>(_InsertarLinea_QNAME, InsertarLinea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaLineaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaLineaResponse")
    public JAXBElement<ListaLineaResponse> createListaLineaResponse(ListaLineaResponse value) {
        return new JAXBElement<ListaLineaResponse>(_ListaLineaResponse_QNAME, ListaLineaResponse.class, null, value);
    }

}
