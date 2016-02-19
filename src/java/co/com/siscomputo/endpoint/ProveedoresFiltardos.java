
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para proveedoresFiltardos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="proveedoresFiltardos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTipoEstado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idCiudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idLinea" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idEmpresa" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idResponsable" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTipoProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTibutaria" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTipoCuenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idFormaPago" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fechai" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proveedoresFiltardos", propOrder = {
    "idTipoEstado",
    "idCiudad",
    "idLinea",
    "idEmpresa",
    "idResponsable",
    "idTipoProveedor",
    "idTibutaria",
    "idTipoCuenta",
    "idFormaPago",
    "fechai",
    "fechaf"
})
public class ProveedoresFiltardos {

    protected Integer idTipoEstado;
    protected Integer idCiudad;
    protected Integer idLinea;
    protected Integer idEmpresa;
    protected Integer idResponsable;
    protected Integer idTipoProveedor;
    protected Integer idTibutaria;
    protected Integer idTipoCuenta;
    protected Integer idFormaPago;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechai;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaf;

    /**
     * Obtiene el valor de la propiedad idTipoEstado.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoEstado() {
        return idTipoEstado;
    }

    /**
     * Define el valor de la propiedad idTipoEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoEstado(Integer value) {
        this.idTipoEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad idCiudad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * Define el valor de la propiedad idCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCiudad(Integer value) {
        this.idCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad idLinea.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdLinea() {
        return idLinea;
    }

    /**
     * Define el valor de la propiedad idLinea.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdLinea(Integer value) {
        this.idLinea = value;
    }

    /**
     * Obtiene el valor de la propiedad idEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Define el valor de la propiedad idEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEmpresa(Integer value) {
        this.idEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad idResponsable.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdResponsable() {
        return idResponsable;
    }

    /**
     * Define el valor de la propiedad idResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdResponsable(Integer value) {
        this.idResponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoProveedor() {
        return idTipoProveedor;
    }

    /**
     * Define el valor de la propiedad idTipoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoProveedor(Integer value) {
        this.idTipoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idTibutaria.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTibutaria() {
        return idTibutaria;
    }

    /**
     * Define el valor de la propiedad idTibutaria.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTibutaria(Integer value) {
        this.idTibutaria = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    /**
     * Define el valor de la propiedad idTipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoCuenta(Integer value) {
        this.idTipoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad idFormaPago.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    /**
     * Define el valor de la propiedad idFormaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdFormaPago(Integer value) {
        this.idFormaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad fechai.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechai() {
        return fechai;
    }

    /**
     * Define el valor de la propiedad fechai.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechai(XMLGregorianCalendar value) {
        this.fechai = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaf.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaf() {
        return fechaf;
    }

    /**
     * Define el valor de la propiedad fechaf.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaf(XMLGregorianCalendar value) {
        this.fechaf = value;
    }

}
