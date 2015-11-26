
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tiposAccesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tiposAccesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorTiposAcceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorTiposAcceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoTiposAcceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTiposAcceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTiposAcceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tiposAccesoEntity", propOrder = {
    "actualizadorTiposAcceso",
    "creadorTiposAcceso",
    "estadoTiposAcceso",
    "idTiposAcceso",
    "nombreTiposAcceso"
})
public class TiposAccesoEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorTiposAcceso;
    protected int creadorTiposAcceso;
    protected String estadoTiposAcceso;
    protected int idTiposAcceso;
    protected String nombreTiposAcceso;

    /**
     * Obtiene el valor de la propiedad actualizadorTiposAcceso.
     * 
     */
    public int getActualizadorTiposAcceso() {
        return actualizadorTiposAcceso;
    }

    /**
     * Define el valor de la propiedad actualizadorTiposAcceso.
     * 
     */
    public void setActualizadorTiposAcceso(int value) {
        this.actualizadorTiposAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorTiposAcceso.
     * 
     */
    public int getCreadorTiposAcceso() {
        return creadorTiposAcceso;
    }

    /**
     * Define el valor de la propiedad creadorTiposAcceso.
     * 
     */
    public void setCreadorTiposAcceso(int value) {
        this.creadorTiposAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoTiposAcceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTiposAcceso() {
        return estadoTiposAcceso;
    }

    /**
     * Define el valor de la propiedad estadoTiposAcceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTiposAcceso(String value) {
        this.estadoTiposAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idTiposAcceso.
     * 
     */
    public int getIdTiposAcceso() {
        return idTiposAcceso;
    }

    /**
     * Define el valor de la propiedad idTiposAcceso.
     * 
     */
    public void setIdTiposAcceso(int value) {
        this.idTiposAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTiposAcceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTiposAcceso() {
        return nombreTiposAcceso;
    }

    /**
     * Define el valor de la propiedad nombreTiposAcceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTiposAcceso(String value) {
        this.nombreTiposAcceso = value;
    }

}
