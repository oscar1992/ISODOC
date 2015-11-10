
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para macroprocesosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="macroprocesosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorMacroproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorMacroproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoMacroproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMacroproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreMacroproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "macroprocesosEntity", propOrder = {
    "actualizadorMacroproceso",
    "creadorMacroproceso",
    "estadoMacroproceso",
    "idMacroproceso",
    "nombreMacroproceso"
})
public class MacroprocesosEntity
    extends ObjetoTraza
{

    protected int actualizadorMacroproceso;
    protected int creadorMacroproceso;
    protected String estadoMacroproceso;
    protected int idMacroproceso;
    protected String nombreMacroproceso;

    /**
     * Obtiene el valor de la propiedad actualizadorMacroproceso.
     * 
     */
    public int getActualizadorMacroproceso() {
        return actualizadorMacroproceso;
    }

    /**
     * Define el valor de la propiedad actualizadorMacroproceso.
     * 
     */
    public void setActualizadorMacroproceso(int value) {
        this.actualizadorMacroproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorMacroproceso.
     * 
     */
    public int getCreadorMacroproceso() {
        return creadorMacroproceso;
    }

    /**
     * Define el valor de la propiedad creadorMacroproceso.
     * 
     */
    public void setCreadorMacroproceso(int value) {
        this.creadorMacroproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoMacroproceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoMacroproceso() {
        return estadoMacroproceso;
    }

    /**
     * Define el valor de la propiedad estadoMacroproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoMacroproceso(String value) {
        this.estadoMacroproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idMacroproceso.
     * 
     */
    public int getIdMacroproceso() {
        return idMacroproceso;
    }

    /**
     * Define el valor de la propiedad idMacroproceso.
     * 
     */
    public void setIdMacroproceso(int value) {
        this.idMacroproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreMacroproceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreMacroproceso() {
        return nombreMacroproceso;
    }

    /**
     * Define el valor de la propiedad nombreMacroproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreMacroproceso(String value) {
        this.nombreMacroproceso = value;
    }

}
