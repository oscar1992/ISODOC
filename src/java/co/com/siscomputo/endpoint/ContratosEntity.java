
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para contratosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contratosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="documentoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInicialContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechafinalContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idAreaContrato" type="{http://endpoint.siscomputo.com.co/}areaEntity" minOccurs="0"/>
 *         &lt;element name="idContrato" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idEmpresaContrato" type="{http://endpoint.siscomputo.com.co/}empresaEntity" minOccurs="0"/>
 *         &lt;element name="idLineaProveedor" type="{http://endpoint.siscomputo.com.co/}lineaEntity" minOccurs="0"/>
 *         &lt;element name="idProveedorContrato" type="{http://endpoint.siscomputo.com.co/}proveedoresEntity" minOccurs="0"/>
 *         &lt;element name="idTipoMoneda" type="{http://endpoint.siscomputo.com.co/}tipoMonedaEntity" minOccurs="0"/>
 *         &lt;element name="idTipoProveedorContrato" type="{http://endpoint.siscomputo.com.co/}tipoProveedorEntity" minOccurs="0"/>
 *         &lt;element name="objetoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plazoEjecucion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="procesoContrato" type="{http://endpoint.siscomputo.com.co/}procesoEntity" minOccurs="0"/>
 *         &lt;element name="supervisorContrato" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *         &lt;element name="valorContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contratosEntity", propOrder = {
    "documentoContrato",
    "estadoContrato",
    "fechaInicialContrato",
    "fechafinalContrato",
    "idAreaContrato",
    "idContrato",
    "idEmpresaContrato",
    "idLineaProveedor",
    "idProveedorContrato",
    "idTipoMoneda",
    "idTipoProveedorContrato",
    "objetoContrato",
    "plazoEjecucion",
    "procesoContrato",
    "supervisorContrato",
    "valorContrato"
})
public class ContratosEntity
    extends ObjetoRetornaEntity
{

    protected String documentoContrato;
    protected String estadoContrato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicialContrato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechafinalContrato;
    protected AreaEntity idAreaContrato;
    protected Integer idContrato;
    protected EmpresaEntity idEmpresaContrato;
    protected LineaEntity idLineaProveedor;
    protected ProveedoresEntity idProveedorContrato;
    protected TipoMonedaEntity idTipoMoneda;
    protected TipoProveedorEntity idTipoProveedorContrato;
    protected String objetoContrato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plazoEjecucion;
    protected ProcesoEntity procesoContrato;
    protected UsuarioEntity supervisorContrato;
    protected String valorContrato;

    /**
     * Obtiene el valor de la propiedad documentoContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoContrato() {
        return documentoContrato;
    }

    /**
     * Define el valor de la propiedad documentoContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoContrato(String value) {
        this.documentoContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoContrato() {
        return estadoContrato;
    }

    /**
     * Define el valor de la propiedad estadoContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoContrato(String value) {
        this.estadoContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicialContrato.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicialContrato() {
        return fechaInicialContrato;
    }

    /**
     * Define el valor de la propiedad fechaInicialContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicialContrato(XMLGregorianCalendar value) {
        this.fechaInicialContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad fechafinalContrato.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechafinalContrato() {
        return fechafinalContrato;
    }

    /**
     * Define el valor de la propiedad fechafinalContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechafinalContrato(XMLGregorianCalendar value) {
        this.fechafinalContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad idAreaContrato.
     * 
     * @return
     *     possible object is
     *     {@link AreaEntity }
     *     
     */
    public AreaEntity getIdAreaContrato() {
        return idAreaContrato;
    }

    /**
     * Define el valor de la propiedad idAreaContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaEntity }
     *     
     */
    public void setIdAreaContrato(AreaEntity value) {
        this.idAreaContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad idContrato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContrato() {
        return idContrato;
    }

    /**
     * Define el valor de la propiedad idContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContrato(Integer value) {
        this.idContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad idEmpresaContrato.
     * 
     * @return
     *     possible object is
     *     {@link EmpresaEntity }
     *     
     */
    public EmpresaEntity getIdEmpresaContrato() {
        return idEmpresaContrato;
    }

    /**
     * Define el valor de la propiedad idEmpresaContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link EmpresaEntity }
     *     
     */
    public void setIdEmpresaContrato(EmpresaEntity value) {
        this.idEmpresaContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad idLineaProveedor.
     * 
     * @return
     *     possible object is
     *     {@link LineaEntity }
     *     
     */
    public LineaEntity getIdLineaProveedor() {
        return idLineaProveedor;
    }

    /**
     * Define el valor de la propiedad idLineaProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link LineaEntity }
     *     
     */
    public void setIdLineaProveedor(LineaEntity value) {
        this.idLineaProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idProveedorContrato.
     * 
     * @return
     *     possible object is
     *     {@link ProveedoresEntity }
     *     
     */
    public ProveedoresEntity getIdProveedorContrato() {
        return idProveedorContrato;
    }

    /**
     * Define el valor de la propiedad idProveedorContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link ProveedoresEntity }
     *     
     */
    public void setIdProveedorContrato(ProveedoresEntity value) {
        this.idProveedorContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoMoneda.
     * 
     * @return
     *     possible object is
     *     {@link TipoMonedaEntity }
     *     
     */
    public TipoMonedaEntity getIdTipoMoneda() {
        return idTipoMoneda;
    }

    /**
     * Define el valor de la propiedad idTipoMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMonedaEntity }
     *     
     */
    public void setIdTipoMoneda(TipoMonedaEntity value) {
        this.idTipoMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoProveedorContrato.
     * 
     * @return
     *     possible object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public TipoProveedorEntity getIdTipoProveedorContrato() {
        return idTipoProveedorContrato;
    }

    /**
     * Define el valor de la propiedad idTipoProveedorContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public void setIdTipoProveedorContrato(TipoProveedorEntity value) {
        this.idTipoProveedorContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad objetoContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjetoContrato() {
        return objetoContrato;
    }

    /**
     * Define el valor de la propiedad objetoContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjetoContrato(String value) {
        this.objetoContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoEjecucion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlazoEjecucion() {
        return plazoEjecucion;
    }

    /**
     * Define el valor de la propiedad plazoEjecucion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlazoEjecucion(XMLGregorianCalendar value) {
        this.plazoEjecucion = value;
    }

    /**
     * Obtiene el valor de la propiedad procesoContrato.
     * 
     * @return
     *     possible object is
     *     {@link ProcesoEntity }
     *     
     */
    public ProcesoEntity getProcesoContrato() {
        return procesoContrato;
    }

    /**
     * Define el valor de la propiedad procesoContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesoEntity }
     *     
     */
    public void setProcesoContrato(ProcesoEntity value) {
        this.procesoContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad supervisorContrato.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getSupervisorContrato() {
        return supervisorContrato;
    }

    /**
     * Define el valor de la propiedad supervisorContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setSupervisorContrato(UsuarioEntity value) {
        this.supervisorContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad valorContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorContrato() {
        return valorContrato;
    }

    /**
     * Define el valor de la propiedad valorContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorContrato(String value) {
        this.valorContrato = value;
    }

}
