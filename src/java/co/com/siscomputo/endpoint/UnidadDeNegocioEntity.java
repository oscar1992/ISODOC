
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para unidadDeNegocioEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="unidadDeNegocioEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoNegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idUnidadNegocio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombreNegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unidadDeNegocioEntity", propOrder = {
    "estadoNegocio",
    "idUnidadNegocio",
    "nombreNegocio"
})
public class UnidadDeNegocioEntity
    extends ObjetoRetornaEntity
{

    protected String estadoNegocio;
    protected Integer idUnidadNegocio;
    protected String nombreNegocio;

    /**
     * Obtiene el valor de la propiedad estadoNegocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNegocio() {
        return estadoNegocio;
    }

    /**
     * Define el valor de la propiedad estadoNegocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNegocio(String value) {
        this.estadoNegocio = value;
    }

    /**
     * Obtiene el valor de la propiedad idUnidadNegocio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    /**
     * Define el valor de la propiedad idUnidadNegocio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUnidadNegocio(Integer value) {
        this.idUnidadNegocio = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreNegocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreNegocio() {
        return nombreNegocio;
    }

    /**
     * Define el valor de la propiedad nombreNegocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreNegocio(String value) {
        this.nombreNegocio = value;
    }

}
