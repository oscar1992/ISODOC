
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para areaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="areaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorArea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigoArea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorArea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idArea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idSede" type="{http://endpoint.siscomputo.com.co/}sedeEntity" minOccurs="0"/>
 *         &lt;element name="nombreArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "areaEntity", propOrder = {
    "actualizadorArea",
    "codigoArea",
    "creadorArea",
    "estadoArea",
    "idArea",
    "idSede",
    "nombreArea"
})
public class AreaEntity
    extends ObjetoTraza
{

    protected int actualizadorArea;
    protected int codigoArea;
    protected int creadorArea;
    protected String estadoArea;
    protected int idArea;
    protected SedeEntity idSede;
    protected String nombreArea;

    /**
     * Obtiene el valor de la propiedad actualizadorArea.
     * 
     */
    public int getActualizadorArea() {
        return actualizadorArea;
    }

    /**
     * Define el valor de la propiedad actualizadorArea.
     * 
     */
    public void setActualizadorArea(int value) {
        this.actualizadorArea = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoArea.
     * 
     */
    public int getCodigoArea() {
        return codigoArea;
    }

    /**
     * Define el valor de la propiedad codigoArea.
     * 
     */
    public void setCodigoArea(int value) {
        this.codigoArea = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorArea.
     * 
     */
    public int getCreadorArea() {
        return creadorArea;
    }

    /**
     * Define el valor de la propiedad creadorArea.
     * 
     */
    public void setCreadorArea(int value) {
        this.creadorArea = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoArea() {
        return estadoArea;
    }

    /**
     * Define el valor de la propiedad estadoArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoArea(String value) {
        this.estadoArea = value;
    }

    /**
     * Obtiene el valor de la propiedad idArea.
     * 
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * Define el valor de la propiedad idArea.
     * 
     */
    public void setIdArea(int value) {
        this.idArea = value;
    }

    /**
     * Obtiene el valor de la propiedad idSede.
     * 
     * @return
     *     possible object is
     *     {@link SedeEntity }
     *     
     */
    public SedeEntity getIdSede() {
        return idSede;
    }

    /**
     * Define el valor de la propiedad idSede.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeEntity }
     *     
     */
    public void setIdSede(SedeEntity value) {
        this.idSede = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArea() {
        return nombreArea;
    }

    /**
     * Define el valor de la propiedad nombreArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArea(String value) {
        this.nombreArea = value;
    }

}
