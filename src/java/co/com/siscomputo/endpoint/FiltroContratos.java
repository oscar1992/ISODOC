
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FiltroContratos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FiltroContratos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdTipoProveedor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="estadoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProveedorContrato" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fechafinalContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiltroContratos", propOrder = {
    "idTipoProveedor",
    "estadoContrato",
    "idProveedorContrato",
    "fechafinalContrato"
})
public class FiltroContratos {

    @XmlElement(name = "IdTipoProveedor")
    protected Integer idTipoProveedor;
    protected String estadoContrato;
    protected Integer idProveedorContrato;
    protected String fechafinalContrato;

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
     * Obtiene el valor de la propiedad idProveedorContrato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProveedorContrato() {
        return idProveedorContrato;
    }

    /**
     * Define el valor de la propiedad idProveedorContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProveedorContrato(Integer value) {
        this.idProveedorContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad fechafinalContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafinalContrato() {
        return fechafinalContrato;
    }

    /**
     * Define el valor de la propiedad fechafinalContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafinalContrato(String value) {
        this.fechafinalContrato = value;
    }

}
