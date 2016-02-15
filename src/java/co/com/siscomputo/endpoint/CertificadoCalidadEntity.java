
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para certificadoCalidadEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="certificadoCalidadEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechacertificado" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idCertificado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idProveedor" type="{http://endpoint.siscomputo.com.co/}proveedoresEntity" minOccurs="0"/>
 *         &lt;element name="tipoCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificadoCalidadEntity", propOrder = {
    "estadoCertificado",
    "fechacertificado",
    "idCertificado",
    "idProveedor",
    "tipoCertificado"
})
public class CertificadoCalidadEntity
    extends ObjetoRetornaEntity
{

    protected String estadoCertificado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechacertificado;
    protected Integer idCertificado;
    protected ProveedoresEntity idProveedor;
    protected String tipoCertificado;

    /**
     * Obtiene el valor de la propiedad estadoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCertificado() {
        return estadoCertificado;
    }

    /**
     * Define el valor de la propiedad estadoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCertificado(String value) {
        this.estadoCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechacertificado.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechacertificado() {
        return fechacertificado;
    }

    /**
     * Define el valor de la propiedad fechacertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechacertificado(XMLGregorianCalendar value) {
        this.fechacertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad idCertificado.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCertificado() {
        return idCertificado;
    }

    /**
     * Define el valor de la propiedad idCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCertificado(Integer value) {
        this.idCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad idProveedor.
     * 
     * @return
     *     possible object is
     *     {@link ProveedoresEntity }
     *     
     */
    public ProveedoresEntity getIdProveedor() {
        return idProveedor;
    }

    /**
     * Define el valor de la propiedad idProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link ProveedoresEntity }
     *     
     */
    public void setIdProveedor(ProveedoresEntity value) {
        this.idProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCertificado() {
        return tipoCertificado;
    }

    /**
     * Define el valor de la propiedad tipoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCertificado(String value) {
        this.tipoCertificado = value;
    }

}
