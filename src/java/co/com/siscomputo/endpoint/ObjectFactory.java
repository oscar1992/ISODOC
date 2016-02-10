
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

    private final static QName _InsertarDocumentoRolResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumentoRolResponse");
    private final static QName _ListaDocumentoPorAccionResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoPorAccionResponse");
    private final static QName _InsertarDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumento");
    private final static QName _ListaDocumentoRol_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoRol");
    private final static QName _ActualizarDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumento");
    private final static QName _InsertarDocumentoRol_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumentoRol");
    private final static QName _InsertarDocumentoProcesoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumentoProcesoResponse");
    private final static QName _ListaDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumento");
    private final static QName _InsertarUsuarioDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarUsuarioDocumento");
    private final static QName _ActualizarUsuarioDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarUsuarioDocumentoResponse");
    private final static QName _ListaDocumentoProceso_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoProceso");
    private final static QName _InsertarUsuarioDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarUsuarioDocumentoResponse");
    private final static QName _ActualizarDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumentoResponse");
    private final static QName _InsertarDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumentoResponse");
    private final static QName _ActualizarDocumentoProcesoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumentoProcesoResponse");
    private final static QName _ActualizarUsuarioDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarUsuarioDocumento");
    private final static QName _ListaDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoResponse");
    private final static QName _ActualizarDocumentoRol_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumentoRol");
    private final static QName _InsertarDocumentoProceso_QNAME = new QName("http://endpoint.siscomputo.com.co/", "insertarDocumentoProceso");
    private final static QName _DocumetosFiltradosResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "documetosFiltradosResponse");
    private final static QName _ListaDocumentoRolResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoRolResponse");
    private final static QName _ListaUsuarioDocumento_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaUsuarioDocumento");
    private final static QName _ListaDocumentoPorAccion_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoPorAccion");
    private final static QName _DocumetosFiltrados_QNAME = new QName("http://endpoint.siscomputo.com.co/", "documetosFiltrados");
    private final static QName _ListaDocumentoProcesoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaDocumentoProcesoResponse");
    private final static QName _ActualizarDocumentoRolResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumentoRolResponse");
    private final static QName _ActualizarDocumentoProceso_QNAME = new QName("http://endpoint.siscomputo.com.co/", "actualizarDocumentoProceso");
    private final static QName _ListaUsuarioDocumentoResponse_QNAME = new QName("http://endpoint.siscomputo.com.co/", "listaUsuarioDocumentoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.siscomputo.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaDocumentoResponse }
     * 
     */
    public ListaDocumentoResponse createListaDocumentoResponse() {
        return new ListaDocumentoResponse();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoRol }
     * 
     */
    public ActualizarDocumentoRol createActualizarDocumentoRol() {
        return new ActualizarDocumentoRol();
    }

    /**
     * Create an instance of {@link InsertarDocumentoProceso }
     * 
     */
    public InsertarDocumentoProceso createInsertarDocumentoProceso() {
        return new InsertarDocumentoProceso();
    }

    /**
     * Create an instance of {@link DocumetosFiltradosResponse }
     * 
     */
    public DocumetosFiltradosResponse createDocumetosFiltradosResponse() {
        return new DocumetosFiltradosResponse();
    }

    /**
     * Create an instance of {@link ListaDocumentoRolResponse }
     * 
     */
    public ListaDocumentoRolResponse createListaDocumentoRolResponse() {
        return new ListaDocumentoRolResponse();
    }

    /**
     * Create an instance of {@link ListaUsuarioDocumento }
     * 
     */
    public ListaUsuarioDocumento createListaUsuarioDocumento() {
        return new ListaUsuarioDocumento();
    }

    /**
     * Create an instance of {@link ListaDocumentoPorAccion }
     * 
     */
    public ListaDocumentoPorAccion createListaDocumentoPorAccion() {
        return new ListaDocumentoPorAccion();
    }

    /**
     * Create an instance of {@link DocumetosFiltrados }
     * 
     */
    public DocumetosFiltrados createDocumetosFiltrados() {
        return new DocumetosFiltrados();
    }

    /**
     * Create an instance of {@link ListaDocumentoProcesoResponse }
     * 
     */
    public ListaDocumentoProcesoResponse createListaDocumentoProcesoResponse() {
        return new ListaDocumentoProcesoResponse();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoRolResponse }
     * 
     */
    public ActualizarDocumentoRolResponse createActualizarDocumentoRolResponse() {
        return new ActualizarDocumentoRolResponse();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoProceso }
     * 
     */
    public ActualizarDocumentoProceso createActualizarDocumentoProceso() {
        return new ActualizarDocumentoProceso();
    }

    /**
     * Create an instance of {@link ListaUsuarioDocumentoResponse }
     * 
     */
    public ListaUsuarioDocumentoResponse createListaUsuarioDocumentoResponse() {
        return new ListaUsuarioDocumentoResponse();
    }

    /**
     * Create an instance of {@link InsertarDocumentoRolResponse }
     * 
     */
    public InsertarDocumentoRolResponse createInsertarDocumentoRolResponse() {
        return new InsertarDocumentoRolResponse();
    }

    /**
     * Create an instance of {@link ListaDocumentoPorAccionResponse }
     * 
     */
    public ListaDocumentoPorAccionResponse createListaDocumentoPorAccionResponse() {
        return new ListaDocumentoPorAccionResponse();
    }

    /**
     * Create an instance of {@link InsertarDocumento }
     * 
     */
    public InsertarDocumento createInsertarDocumento() {
        return new InsertarDocumento();
    }

    /**
     * Create an instance of {@link ListaDocumentoRol }
     * 
     */
    public ListaDocumentoRol createListaDocumentoRol() {
        return new ListaDocumentoRol();
    }

    /**
     * Create an instance of {@link ActualizarDocumento }
     * 
     */
    public ActualizarDocumento createActualizarDocumento() {
        return new ActualizarDocumento();
    }

    /**
     * Create an instance of {@link InsertarDocumentoRol }
     * 
     */
    public InsertarDocumentoRol createInsertarDocumentoRol() {
        return new InsertarDocumentoRol();
    }

    /**
     * Create an instance of {@link InsertarDocumentoProcesoResponse }
     * 
     */
    public InsertarDocumentoProcesoResponse createInsertarDocumentoProcesoResponse() {
        return new InsertarDocumentoProcesoResponse();
    }

    /**
     * Create an instance of {@link ListaDocumento }
     * 
     */
    public ListaDocumento createListaDocumento() {
        return new ListaDocumento();
    }

    /**
     * Create an instance of {@link InsertarUsuarioDocumento }
     * 
     */
    public InsertarUsuarioDocumento createInsertarUsuarioDocumento() {
        return new InsertarUsuarioDocumento();
    }

    /**
     * Create an instance of {@link ActualizarUsuarioDocumentoResponse }
     * 
     */
    public ActualizarUsuarioDocumentoResponse createActualizarUsuarioDocumentoResponse() {
        return new ActualizarUsuarioDocumentoResponse();
    }

    /**
     * Create an instance of {@link ListaDocumentoProceso }
     * 
     */
    public ListaDocumentoProceso createListaDocumentoProceso() {
        return new ListaDocumentoProceso();
    }

    /**
     * Create an instance of {@link InsertarUsuarioDocumentoResponse }
     * 
     */
    public InsertarUsuarioDocumentoResponse createInsertarUsuarioDocumentoResponse() {
        return new InsertarUsuarioDocumentoResponse();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoResponse }
     * 
     */
    public ActualizarDocumentoResponse createActualizarDocumentoResponse() {
        return new ActualizarDocumentoResponse();
    }

    /**
     * Create an instance of {@link InsertarDocumentoResponse }
     * 
     */
    public InsertarDocumentoResponse createInsertarDocumentoResponse() {
        return new InsertarDocumentoResponse();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoProcesoResponse }
     * 
     */
    public ActualizarDocumentoProcesoResponse createActualizarDocumentoProcesoResponse() {
        return new ActualizarDocumentoProcesoResponse();
    }

    /**
     * Create an instance of {@link ActualizarUsuarioDocumento }
     * 
     */
    public ActualizarUsuarioDocumento createActualizarUsuarioDocumento() {
        return new ActualizarUsuarioDocumento();
    }

    /**
     * Create an instance of {@link ObjetoRetornaEntity }
     * 
     */
    public ObjetoRetornaEntity createObjetoRetornaEntity() {
        return new ObjetoRetornaEntity();
    }

    /**
     * Create an instance of {@link UsuarioDocumentoEntity }
     * 
     */
    public UsuarioDocumentoEntity createUsuarioDocumentoEntity() {
        return new UsuarioDocumentoEntity();
    }

    /**
     * Create an instance of {@link ObjetoTraza }
     * 
     */
    public ObjetoTraza createObjetoTraza() {
        return new ObjetoTraza();
    }

    /**
     * Create an instance of {@link UsuarioEntity }
     * 
     */
    public UsuarioEntity createUsuarioEntity() {
        return new UsuarioEntity();
    }

    /**
     * Create an instance of {@link DocumentoRolEntity }
     * 
     */
    public DocumentoRolEntity createDocumentoRolEntity() {
        return new DocumentoRolEntity();
    }

    /**
     * Create an instance of {@link TiposDocumentalesEntity }
     * 
     */
    public TiposDocumentalesEntity createTiposDocumentalesEntity() {
        return new TiposDocumentalesEntity();
    }

    /**
     * Create an instance of {@link ProcesoEntity }
     * 
     */
    public ProcesoEntity createProcesoEntity() {
        return new ProcesoEntity();
    }

    /**
     * Create an instance of {@link RolesEntity }
     * 
     */
    public RolesEntity createRolesEntity() {
        return new RolesEntity();
    }

    /**
     * Create an instance of {@link DocumentoProcesoEntity }
     * 
     */
    public DocumentoProcesoEntity createDocumentoProcesoEntity() {
        return new DocumentoProcesoEntity();
    }

    /**
     * Create an instance of {@link AccionEntity }
     * 
     */
    public AccionEntity createAccionEntity() {
        return new AccionEntity();
    }

    /**
     * Create an instance of {@link PlantillaEntity }
     * 
     */
    public PlantillaEntity createPlantillaEntity() {
        return new PlantillaEntity();
    }

    /**
     * Create an instance of {@link DocumentoEntity }
     * 
     */
    public DocumentoEntity createDocumentoEntity() {
        return new DocumentoEntity();
    }

    /**
     * Create an instance of {@link NivelEntity }
     * 
     */
    public NivelEntity createNivelEntity() {
        return new NivelEntity();
    }

    /**
     * Create an instance of {@link EmpresaEntity }
     * 
     */
    public EmpresaEntity createEmpresaEntity() {
        return new EmpresaEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumentoRolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumentoRolResponse")
    public JAXBElement<InsertarDocumentoRolResponse> createInsertarDocumentoRolResponse(InsertarDocumentoRolResponse value) {
        return new JAXBElement<InsertarDocumentoRolResponse>(_InsertarDocumentoRolResponse_QNAME, InsertarDocumentoRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoPorAccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoPorAccionResponse")
    public JAXBElement<ListaDocumentoPorAccionResponse> createListaDocumentoPorAccionResponse(ListaDocumentoPorAccionResponse value) {
        return new JAXBElement<ListaDocumentoPorAccionResponse>(_ListaDocumentoPorAccionResponse_QNAME, ListaDocumentoPorAccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumento")
    public JAXBElement<InsertarDocumento> createInsertarDocumento(InsertarDocumento value) {
        return new JAXBElement<InsertarDocumento>(_InsertarDocumento_QNAME, InsertarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoRol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoRol")
    public JAXBElement<ListaDocumentoRol> createListaDocumentoRol(ListaDocumentoRol value) {
        return new JAXBElement<ListaDocumentoRol>(_ListaDocumentoRol_QNAME, ListaDocumentoRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumento")
    public JAXBElement<ActualizarDocumento> createActualizarDocumento(ActualizarDocumento value) {
        return new JAXBElement<ActualizarDocumento>(_ActualizarDocumento_QNAME, ActualizarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumentoRol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumentoRol")
    public JAXBElement<InsertarDocumentoRol> createInsertarDocumentoRol(InsertarDocumentoRol value) {
        return new JAXBElement<InsertarDocumentoRol>(_InsertarDocumentoRol_QNAME, InsertarDocumentoRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumentoProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumentoProcesoResponse")
    public JAXBElement<InsertarDocumentoProcesoResponse> createInsertarDocumentoProcesoResponse(InsertarDocumentoProcesoResponse value) {
        return new JAXBElement<InsertarDocumentoProcesoResponse>(_InsertarDocumentoProcesoResponse_QNAME, InsertarDocumentoProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumento")
    public JAXBElement<ListaDocumento> createListaDocumento(ListaDocumento value) {
        return new JAXBElement<ListaDocumento>(_ListaDocumento_QNAME, ListaDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuarioDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarUsuarioDocumento")
    public JAXBElement<InsertarUsuarioDocumento> createInsertarUsuarioDocumento(InsertarUsuarioDocumento value) {
        return new JAXBElement<InsertarUsuarioDocumento>(_InsertarUsuarioDocumento_QNAME, InsertarUsuarioDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarUsuarioDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarUsuarioDocumentoResponse")
    public JAXBElement<ActualizarUsuarioDocumentoResponse> createActualizarUsuarioDocumentoResponse(ActualizarUsuarioDocumentoResponse value) {
        return new JAXBElement<ActualizarUsuarioDocumentoResponse>(_ActualizarUsuarioDocumentoResponse_QNAME, ActualizarUsuarioDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoProceso")
    public JAXBElement<ListaDocumentoProceso> createListaDocumentoProceso(ListaDocumentoProceso value) {
        return new JAXBElement<ListaDocumentoProceso>(_ListaDocumentoProceso_QNAME, ListaDocumentoProceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuarioDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarUsuarioDocumentoResponse")
    public JAXBElement<InsertarUsuarioDocumentoResponse> createInsertarUsuarioDocumentoResponse(InsertarUsuarioDocumentoResponse value) {
        return new JAXBElement<InsertarUsuarioDocumentoResponse>(_InsertarUsuarioDocumentoResponse_QNAME, InsertarUsuarioDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumentoResponse")
    public JAXBElement<ActualizarDocumentoResponse> createActualizarDocumentoResponse(ActualizarDocumentoResponse value) {
        return new JAXBElement<ActualizarDocumentoResponse>(_ActualizarDocumentoResponse_QNAME, ActualizarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumentoResponse")
    public JAXBElement<InsertarDocumentoResponse> createInsertarDocumentoResponse(InsertarDocumentoResponse value) {
        return new JAXBElement<InsertarDocumentoResponse>(_InsertarDocumentoResponse_QNAME, InsertarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumentoProcesoResponse")
    public JAXBElement<ActualizarDocumentoProcesoResponse> createActualizarDocumentoProcesoResponse(ActualizarDocumentoProcesoResponse value) {
        return new JAXBElement<ActualizarDocumentoProcesoResponse>(_ActualizarDocumentoProcesoResponse_QNAME, ActualizarDocumentoProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarUsuarioDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarUsuarioDocumento")
    public JAXBElement<ActualizarUsuarioDocumento> createActualizarUsuarioDocumento(ActualizarUsuarioDocumento value) {
        return new JAXBElement<ActualizarUsuarioDocumento>(_ActualizarUsuarioDocumento_QNAME, ActualizarUsuarioDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoResponse")
    public JAXBElement<ListaDocumentoResponse> createListaDocumentoResponse(ListaDocumentoResponse value) {
        return new JAXBElement<ListaDocumentoResponse>(_ListaDocumentoResponse_QNAME, ListaDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoRol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumentoRol")
    public JAXBElement<ActualizarDocumentoRol> createActualizarDocumentoRol(ActualizarDocumentoRol value) {
        return new JAXBElement<ActualizarDocumentoRol>(_ActualizarDocumentoRol_QNAME, ActualizarDocumentoRol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarDocumentoProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "insertarDocumentoProceso")
    public JAXBElement<InsertarDocumentoProceso> createInsertarDocumentoProceso(InsertarDocumentoProceso value) {
        return new JAXBElement<InsertarDocumentoProceso>(_InsertarDocumentoProceso_QNAME, InsertarDocumentoProceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumetosFiltradosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "documetosFiltradosResponse")
    public JAXBElement<DocumetosFiltradosResponse> createDocumetosFiltradosResponse(DocumetosFiltradosResponse value) {
        return new JAXBElement<DocumetosFiltradosResponse>(_DocumetosFiltradosResponse_QNAME, DocumetosFiltradosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoRolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoRolResponse")
    public JAXBElement<ListaDocumentoRolResponse> createListaDocumentoRolResponse(ListaDocumentoRolResponse value) {
        return new JAXBElement<ListaDocumentoRolResponse>(_ListaDocumentoRolResponse_QNAME, ListaDocumentoRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUsuarioDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaUsuarioDocumento")
    public JAXBElement<ListaUsuarioDocumento> createListaUsuarioDocumento(ListaUsuarioDocumento value) {
        return new JAXBElement<ListaUsuarioDocumento>(_ListaUsuarioDocumento_QNAME, ListaUsuarioDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoPorAccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoPorAccion")
    public JAXBElement<ListaDocumentoPorAccion> createListaDocumentoPorAccion(ListaDocumentoPorAccion value) {
        return new JAXBElement<ListaDocumentoPorAccion>(_ListaDocumentoPorAccion_QNAME, ListaDocumentoPorAccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumetosFiltrados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "documetosFiltrados")
    public JAXBElement<DocumetosFiltrados> createDocumetosFiltrados(DocumetosFiltrados value) {
        return new JAXBElement<DocumetosFiltrados>(_DocumetosFiltrados_QNAME, DocumetosFiltrados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaDocumentoProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaDocumentoProcesoResponse")
    public JAXBElement<ListaDocumentoProcesoResponse> createListaDocumentoProcesoResponse(ListaDocumentoProcesoResponse value) {
        return new JAXBElement<ListaDocumentoProcesoResponse>(_ListaDocumentoProcesoResponse_QNAME, ListaDocumentoProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoRolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumentoRolResponse")
    public JAXBElement<ActualizarDocumentoRolResponse> createActualizarDocumentoRolResponse(ActualizarDocumentoRolResponse value) {
        return new JAXBElement<ActualizarDocumentoRolResponse>(_ActualizarDocumentoRolResponse_QNAME, ActualizarDocumentoRolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "actualizarDocumentoProceso")
    public JAXBElement<ActualizarDocumentoProceso> createActualizarDocumentoProceso(ActualizarDocumentoProceso value) {
        return new JAXBElement<ActualizarDocumentoProceso>(_ActualizarDocumentoProceso_QNAME, ActualizarDocumentoProceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUsuarioDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.siscomputo.com.co/", name = "listaUsuarioDocumentoResponse")
    public JAXBElement<ListaUsuarioDocumentoResponse> createListaUsuarioDocumentoResponse(ListaUsuarioDocumentoResponse value) {
        return new JAXBElement<ListaUsuarioDocumentoResponse>(_ListaUsuarioDocumentoResponse_QNAME, ListaUsuarioDocumentoResponse.class, null, value);
    }

}
