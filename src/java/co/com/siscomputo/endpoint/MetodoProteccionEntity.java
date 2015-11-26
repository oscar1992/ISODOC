
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para metodoProteccionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="metodoProteccionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorMetodoProteccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorMetodoProteccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoMetodoProteccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMetodoProteccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreMetodoProteccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metodoProteccionEntity", propOrder = {
    "actualizadorMetodoProteccion",
    "creadorMetodoProteccion",
    "estadoMetodoProteccion",
    "idMetodoProteccion",
    "nombreMetodoProteccion"
})
public class MetodoProteccionEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorMetodoProteccion;
    protected int creadorMetodoProteccion;
    protected String estadoMetodoProteccion;
    protected int idMetodoProteccion;
    protected String nombreMetodoProteccion;

    /**
     * Obtiene el valor de la propiedad actualizadorMetodoProteccion.
     * 
     */
    public int getActualizadorMetodoProteccion() {
        return actualizadorMetodoProteccion;
    }

    /**
     * Define el valor de la propiedad actualizadorMetodoProteccion.
     * 
     */
    public void setActualizadorMetodoProteccion(int value) {
        this.actualizadorMetodoProteccion = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorMetodoProteccion.
     * 
     */
    public int getCreadorMetodoProteccion() {
        return creadorMetodoProteccion;
    }

    /**
     * Define el valor de la propiedad creadorMetodoProteccion.
     * 
     */
    public void setCreadorMetodoProteccion(int value) {
        this.creadorMetodoProteccion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoMetodoProteccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoMetodoProteccion() {
        return estadoMetodoProteccion;
    }

    /**
     * Define el valor de la propiedad estadoMetodoProteccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoMetodoProteccion(String value) {
        this.estadoMetodoProteccion = value;
    }

    /**
     * Obtiene el valor de la propiedad idMetodoProteccion.
     * 
     */
    public int getIdMetodoProteccion() {
        return idMetodoProteccion;
    }

    /**
     * Define el valor de la propiedad idMetodoProteccion.
     * 
     */
    public void setIdMetodoProteccion(int value) {
        this.idMetodoProteccion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreMetodoProteccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreMetodoProteccion() {
        return nombreMetodoProteccion;
    }

    /**
     * Define el valor de la propiedad nombreMetodoProteccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreMetodoProteccion(String value) {
        this.nombreMetodoProteccion = value;
    }

}
