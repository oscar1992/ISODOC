
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para origenEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="origenEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="aliasOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idOrigen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "origenEntity", propOrder = {
    "aliasOrigen",
    "estadoOrigen",
    "idOrigen",
    "tipoOrigen"
})
public class OrigenEntity
    extends ObjetoRetornaEntity
{

    protected String aliasOrigen;
    protected String estadoOrigen;
    protected Integer idOrigen;
    protected String tipoOrigen;

    /**
     * Obtiene el valor de la propiedad aliasOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasOrigen() {
        return aliasOrigen;
    }

    /**
     * Define el valor de la propiedad aliasOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasOrigen(String value) {
        this.aliasOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    /**
     * Define el valor de la propiedad estadoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoOrigen(String value) {
        this.estadoOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrigen.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOrigen() {
        return idOrigen;
    }

    /**
     * Define el valor de la propiedad idOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOrigen(Integer value) {
        this.idOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOrigen() {
        return tipoOrigen;
    }

    /**
     * Define el valor de la propiedad tipoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOrigen(String value) {
        this.tipoOrigen = value;
    }

}
