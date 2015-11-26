
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para metodoRecuperacionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="metodoRecuperacionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorMetdodoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorMetodoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoMetodoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMetodoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreMetodoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metodoRecuperacionEntity", propOrder = {
    "actualizadorMetdodoRecuperacion",
    "creadorMetodoRecuperacion",
    "estadoMetodoRecuperacion",
    "idMetodoRecuperacion",
    "nombreMetodoRecuperacion"
})
public class MetodoRecuperacionEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorMetdodoRecuperacion;
    protected int creadorMetodoRecuperacion;
    protected String estadoMetodoRecuperacion;
    protected int idMetodoRecuperacion;
    protected String nombreMetodoRecuperacion;

    /**
     * Obtiene el valor de la propiedad actualizadorMetdodoRecuperacion.
     * 
     */
    public int getActualizadorMetdodoRecuperacion() {
        return actualizadorMetdodoRecuperacion;
    }

    /**
     * Define el valor de la propiedad actualizadorMetdodoRecuperacion.
     * 
     */
    public void setActualizadorMetdodoRecuperacion(int value) {
        this.actualizadorMetdodoRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorMetodoRecuperacion.
     * 
     */
    public int getCreadorMetodoRecuperacion() {
        return creadorMetodoRecuperacion;
    }

    /**
     * Define el valor de la propiedad creadorMetodoRecuperacion.
     * 
     */
    public void setCreadorMetodoRecuperacion(int value) {
        this.creadorMetodoRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoMetodoRecuperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoMetodoRecuperacion() {
        return estadoMetodoRecuperacion;
    }

    /**
     * Define el valor de la propiedad estadoMetodoRecuperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoMetodoRecuperacion(String value) {
        this.estadoMetodoRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad idMetodoRecuperacion.
     * 
     */
    public int getIdMetodoRecuperacion() {
        return idMetodoRecuperacion;
    }

    /**
     * Define el valor de la propiedad idMetodoRecuperacion.
     * 
     */
    public void setIdMetodoRecuperacion(int value) {
        this.idMetodoRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreMetodoRecuperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreMetodoRecuperacion() {
        return nombreMetodoRecuperacion;
    }

    /**
     * Define el valor de la propiedad nombreMetodoRecuperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreMetodoRecuperacion(String value) {
        this.nombreMetodoRecuperacion = value;
    }

}
