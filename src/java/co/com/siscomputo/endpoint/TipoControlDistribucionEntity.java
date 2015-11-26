
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoControlDistribucionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoControlDistribucionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorTipoControlDistribucion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorTipoControlDistribucion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoTipoControlDistribucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoControlDistribucion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTipoControlDistribucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoControlDistribucionEntity", propOrder = {
    "actualizadorTipoControlDistribucion",
    "creadorTipoControlDistribucion",
    "estadoTipoControlDistribucion",
    "idTipoControlDistribucion",
    "nombreTipoControlDistribucion"
})
public class TipoControlDistribucionEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorTipoControlDistribucion;
    protected int creadorTipoControlDistribucion;
    protected String estadoTipoControlDistribucion;
    protected int idTipoControlDistribucion;
    protected String nombreTipoControlDistribucion;

    /**
     * Obtiene el valor de la propiedad actualizadorTipoControlDistribucion.
     * 
     */
    public int getActualizadorTipoControlDistribucion() {
        return actualizadorTipoControlDistribucion;
    }

    /**
     * Define el valor de la propiedad actualizadorTipoControlDistribucion.
     * 
     */
    public void setActualizadorTipoControlDistribucion(int value) {
        this.actualizadorTipoControlDistribucion = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorTipoControlDistribucion.
     * 
     */
    public int getCreadorTipoControlDistribucion() {
        return creadorTipoControlDistribucion;
    }

    /**
     * Define el valor de la propiedad creadorTipoControlDistribucion.
     * 
     */
    public void setCreadorTipoControlDistribucion(int value) {
        this.creadorTipoControlDistribucion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoTipoControlDistribucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoControlDistribucion() {
        return estadoTipoControlDistribucion;
    }

    /**
     * Define el valor de la propiedad estadoTipoControlDistribucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoControlDistribucion(String value) {
        this.estadoTipoControlDistribucion = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoControlDistribucion.
     * 
     */
    public int getIdTipoControlDistribucion() {
        return idTipoControlDistribucion;
    }

    /**
     * Define el valor de la propiedad idTipoControlDistribucion.
     * 
     */
    public void setIdTipoControlDistribucion(int value) {
        this.idTipoControlDistribucion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoControlDistribucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoControlDistribucion() {
        return nombreTipoControlDistribucion;
    }

    /**
     * Define el valor de la propiedad nombreTipoControlDistribucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoControlDistribucion(String value) {
        this.nombreTipoControlDistribucion = value;
    }

}
