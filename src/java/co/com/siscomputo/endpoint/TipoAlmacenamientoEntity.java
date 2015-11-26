
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoAlmacenamientoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoAlmacenamientoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorTipoAlmacenamiento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorTipoAlmacenamiento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoTipoAlmacenamiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoAlmacenamiento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTipoAlmacenamiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoAlmacenamientoEntity", propOrder = {
    "actualizadorTipoAlmacenamiento",
    "creadorTipoAlmacenamiento",
    "estadoTipoAlmacenamiento",
    "idTipoAlmacenamiento",
    "nombreTipoAlmacenamiento"
})
public class TipoAlmacenamientoEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorTipoAlmacenamiento;
    protected int creadorTipoAlmacenamiento;
    protected String estadoTipoAlmacenamiento;
    protected int idTipoAlmacenamiento;
    protected String nombreTipoAlmacenamiento;

    /**
     * Obtiene el valor de la propiedad actualizadorTipoAlmacenamiento.
     * 
     */
    public int getActualizadorTipoAlmacenamiento() {
        return actualizadorTipoAlmacenamiento;
    }

    /**
     * Define el valor de la propiedad actualizadorTipoAlmacenamiento.
     * 
     */
    public void setActualizadorTipoAlmacenamiento(int value) {
        this.actualizadorTipoAlmacenamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorTipoAlmacenamiento.
     * 
     */
    public int getCreadorTipoAlmacenamiento() {
        return creadorTipoAlmacenamiento;
    }

    /**
     * Define el valor de la propiedad creadorTipoAlmacenamiento.
     * 
     */
    public void setCreadorTipoAlmacenamiento(int value) {
        this.creadorTipoAlmacenamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoTipoAlmacenamiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoAlmacenamiento() {
        return estadoTipoAlmacenamiento;
    }

    /**
     * Define el valor de la propiedad estadoTipoAlmacenamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoAlmacenamiento(String value) {
        this.estadoTipoAlmacenamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoAlmacenamiento.
     * 
     */
    public int getIdTipoAlmacenamiento() {
        return idTipoAlmacenamiento;
    }

    /**
     * Define el valor de la propiedad idTipoAlmacenamiento.
     * 
     */
    public void setIdTipoAlmacenamiento(int value) {
        this.idTipoAlmacenamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoAlmacenamiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoAlmacenamiento() {
        return nombreTipoAlmacenamiento;
    }

    /**
     * Define el valor de la propiedad nombreTipoAlmacenamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoAlmacenamiento(String value) {
        this.nombreTipoAlmacenamiento = value;
    }

}
