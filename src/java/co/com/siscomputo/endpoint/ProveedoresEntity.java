
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para proveedoresEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="proveedoresEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actividadEconomicaProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cargoContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="celularProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificadoCalidadProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ciudadProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="direccionProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empresaProveedor" type="{http://endpoint.siscomputo.com.co/}empresaEntity" minOccurs="0"/>
 *         &lt;element name="estadoProveedor" type="{http://endpoint.siscomputo.com.co/}estadoProveedorEntity" minOccurs="0"/>
 *         &lt;element name="estadoProveedores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idFormaPago" type="{http://endpoint.siscomputo.com.co/}formasPagoEntity" minOccurs="0"/>
 *         &lt;element name="idProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTipoProveedor" type="{http://endpoint.siscomputo.com.co/}tipoProveedorEntity" minOccurs="0"/>
 *         &lt;element name="idTipoTributario" type="{http://endpoint.siscomputo.com.co/}tipoTributarioEntity" minOccurs="0"/>
 *         &lt;element name="idTipocuenta" type="{http://endpoint.siscomputo.com.co/}tipoCuentaEntity" minOccurs="0"/>
 *         &lt;element name="lineaProveedores" type="{http://endpoint.siscomputo.com.co/}lineaEntity" minOccurs="0"/>
 *         &lt;element name="nombreContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paginaWebProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonoContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDocumentoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioResponsable" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proveedoresEntity", propOrder = {
    "actividadEconomicaProveedor",
    "cargoContacto",
    "celularProveedor",
    "certificadoCalidadProveedor",
    "ciudadProveedor",
    "direccionProveedor",
    "emailContacto",
    "emailProveedor",
    "empresaProveedor",
    "estadoProveedor",
    "estadoProveedores",
    "fechaCreacion",
    "idFormaPago",
    "idProveedor",
    "idTipoProveedor",
    "idTipoTributario",
    "idTipocuenta",
    "lineaProveedores",
    "nombreContacto",
    "nombreProveedor",
    "paginaWebProveedor",
    "telefonoContacto",
    "telefonoProveedor",
    "tipoDocumentoProveedor",
    "urlDocumento",
    "usuarioResponsable"
})
public class ProveedoresEntity
    extends ObjetoRetornaEntity
{

    protected String actividadEconomicaProveedor;
    protected String cargoContacto;
    protected String celularProveedor;
    protected String certificadoCalidadProveedor;
    protected Integer ciudadProveedor;
    protected String direccionProveedor;
    protected String emailContacto;
    protected String emailProveedor;
    protected EmpresaEntity empresaProveedor;
    protected EstadoProveedorEntity estadoProveedor;
    protected String estadoProveedores;
    protected String fechaCreacion;
    protected FormasPagoEntity idFormaPago;
    protected Integer idProveedor;
    protected TipoProveedorEntity idTipoProveedor;
    protected TipoTributarioEntity idTipoTributario;
    protected TipoCuentaEntity idTipocuenta;
    protected LineaEntity lineaProveedores;
    protected String nombreContacto;
    protected String nombreProveedor;
    protected String paginaWebProveedor;
    protected String telefonoContacto;
    protected String telefonoProveedor;
    protected String tipoDocumentoProveedor;
    protected String urlDocumento;
    protected UsuarioEntity usuarioResponsable;

    /**
     * Obtiene el valor de la propiedad actividadEconomicaProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividadEconomicaProveedor() {
        return actividadEconomicaProveedor;
    }

    /**
     * Define el valor de la propiedad actividadEconomicaProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividadEconomicaProveedor(String value) {
        this.actividadEconomicaProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad cargoContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargoContacto() {
        return cargoContacto;
    }

    /**
     * Define el valor de la propiedad cargoContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargoContacto(String value) {
        this.cargoContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad celularProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelularProveedor() {
        return celularProveedor;
    }

    /**
     * Define el valor de la propiedad celularProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelularProveedor(String value) {
        this.celularProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad certificadoCalidadProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificadoCalidadProveedor() {
        return certificadoCalidadProveedor;
    }

    /**
     * Define el valor de la propiedad certificadoCalidadProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificadoCalidadProveedor(String value) {
        this.certificadoCalidadProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadProveedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiudadProveedor() {
        return ciudadProveedor;
    }

    /**
     * Define el valor de la propiedad ciudadProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiudadProveedor(Integer value) {
        this.ciudadProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    /**
     * Define el valor de la propiedad direccionProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionProveedor(String value) {
        this.direccionProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad emailContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailContacto() {
        return emailContacto;
    }

    /**
     * Define el valor de la propiedad emailContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailContacto(String value) {
        this.emailContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad emailProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailProveedor() {
        return emailProveedor;
    }

    /**
     * Define el valor de la propiedad emailProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailProveedor(String value) {
        this.emailProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad empresaProveedor.
     * 
     * @return
     *     possible object is
     *     {@link EmpresaEntity }
     *     
     */
    public EmpresaEntity getEmpresaProveedor() {
        return empresaProveedor;
    }

    /**
     * Define el valor de la propiedad empresaProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link EmpresaEntity }
     *     
     */
    public void setEmpresaProveedor(EmpresaEntity value) {
        this.empresaProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link EstadoProveedorEntity }
     *     
     */
    public EstadoProveedorEntity getEstadoProveedor() {
        return estadoProveedor;
    }

    /**
     * Define el valor de la propiedad estadoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoProveedorEntity }
     *     
     */
    public void setEstadoProveedor(EstadoProveedorEntity value) {
        this.estadoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoProveedores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoProveedores() {
        return estadoProveedores;
    }

    /**
     * Define el valor de la propiedad estadoProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoProveedores(String value) {
        this.estadoProveedores = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Define el valor de la propiedad fechaCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCreacion(String value) {
        this.fechaCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad idFormaPago.
     * 
     * @return
     *     possible object is
     *     {@link FormasPagoEntity }
     *     
     */
    public FormasPagoEntity getIdFormaPago() {
        return idFormaPago;
    }

    /**
     * Define el valor de la propiedad idFormaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link FormasPagoEntity }
     *     
     */
    public void setIdFormaPago(FormasPagoEntity value) {
        this.idFormaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad idProveedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * Define el valor de la propiedad idProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProveedor(Integer value) {
        this.idProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public TipoProveedorEntity getIdTipoProveedor() {
        return idTipoProveedor;
    }

    /**
     * Define el valor de la propiedad idTipoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public void setIdTipoProveedor(TipoProveedorEntity value) {
        this.idTipoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoTributario.
     * 
     * @return
     *     possible object is
     *     {@link TipoTributarioEntity }
     *     
     */
    public TipoTributarioEntity getIdTipoTributario() {
        return idTipoTributario;
    }

    /**
     * Define el valor de la propiedad idTipoTributario.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTributarioEntity }
     *     
     */
    public void setIdTipoTributario(TipoTributarioEntity value) {
        this.idTipoTributario = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipocuenta.
     * 
     * @return
     *     possible object is
     *     {@link TipoCuentaEntity }
     *     
     */
    public TipoCuentaEntity getIdTipocuenta() {
        return idTipocuenta;
    }

    /**
     * Define el valor de la propiedad idTipocuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCuentaEntity }
     *     
     */
    public void setIdTipocuenta(TipoCuentaEntity value) {
        this.idTipocuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad lineaProveedores.
     * 
     * @return
     *     possible object is
     *     {@link LineaEntity }
     *     
     */
    public LineaEntity getLineaProveedores() {
        return lineaProveedores;
    }

    /**
     * Define el valor de la propiedad lineaProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link LineaEntity }
     *     
     */
    public void setLineaProveedores(LineaEntity value) {
        this.lineaProveedores = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Define el valor de la propiedad nombreContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreContacto(String value) {
        this.nombreContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Define el valor de la propiedad nombreProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProveedor(String value) {
        this.nombreProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad paginaWebProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaginaWebProveedor() {
        return paginaWebProveedor;
    }

    /**
     * Define el valor de la propiedad paginaWebProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaginaWebProveedor(String value) {
        this.paginaWebProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Define el valor de la propiedad telefonoContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoContacto(String value) {
        this.telefonoContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    /**
     * Define el valor de la propiedad telefonoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoProveedor(String value) {
        this.telefonoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoProveedor() {
        return tipoDocumentoProveedor;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoProveedor(String value) {
        this.tipoDocumentoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad urlDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlDocumento() {
        return urlDocumento;
    }

    /**
     * Define el valor de la propiedad urlDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlDocumento(String value) {
        this.urlDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioResponsable.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuarioResponsable() {
        return usuarioResponsable;
    }

    /**
     * Define el valor de la propiedad usuarioResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuarioResponsable(UsuarioEntity value) {
        this.usuarioResponsable = value;
    }

}
