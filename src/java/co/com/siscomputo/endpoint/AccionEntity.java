
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para accionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="accionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="descripcionAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ordenAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accionEntity", propOrder = {
    "actualizadorAccion",
    "creadorAccion",
    "descripcionAccion",
    "estadoAccion",
    "idAccion",
    "nombreAccion",
    "ordenAccion"
})
public class AccionEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorAccion;
    protected int creadorAccion;
    protected String descripcionAccion;
    protected String estadoAccion;
    protected int idAccion;
    protected String nombreAccion;
    protected String ordenAccion;

    /**
     * Obtiene el valor de la propiedad actualizadorAccion.
     * 
     */
    public int getActualizadorAccion() {
        return actualizadorAccion;
    }

    /**
     * Define el valor de la propiedad actualizadorAccion.
     * 
     */
    public void setActualizadorAccion(int value) {
        this.actualizadorAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorAccion.
     * 
     */
    public int getCreadorAccion() {
        return creadorAccion;
    }

    /**
     * Define el valor de la propiedad creadorAccion.
     * 
     */
    public void setCreadorAccion(int value) {
        this.creadorAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionAccion() {
        return descripcionAccion;
    }

    /**
     * Define el valor de la propiedad descripcionAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionAccion(String value) {
        this.descripcionAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoAccion() {
        return estadoAccion;
    }

    /**
     * Define el valor de la propiedad estadoAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoAccion(String value) {
        this.estadoAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad idAccion.
     * 
     */
    public int getIdAccion() {
        return idAccion;
    }

    /**
     * Define el valor de la propiedad idAccion.
     * 
     */
    public void setIdAccion(int value) {
        this.idAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAccion() {
        return nombreAccion;
    }

    /**
     * Define el valor de la propiedad nombreAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAccion(String value) {
        this.nombreAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad ordenAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdenAccion() {
        return ordenAccion;
    }

    /**
     * Define el valor de la propiedad ordenAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdenAccion(String value) {
        this.ordenAccion = value;
    }

}
