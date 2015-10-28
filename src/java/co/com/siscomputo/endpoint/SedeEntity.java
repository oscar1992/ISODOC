
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sedeEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sedeEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorSede" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigoSede" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorSede" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSede" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sedeEntity", propOrder = {
    "actualizadorSede",
    "codigoSede",
    "creadorSede",
    "estadoSede",
    "idSede",
    "nombreSede"
})
public class SedeEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorSede;
    protected int codigoSede;
    protected int creadorSede;
    protected String estadoSede;
    protected int idSede;
    protected String nombreSede;

    /**
     * Obtiene el valor de la propiedad actualizadorSede.
     * 
     */
    public int getActualizadorSede() {
        return actualizadorSede;
    }

    /**
     * Define el valor de la propiedad actualizadorSede.
     * 
     */
    public void setActualizadorSede(int value) {
        this.actualizadorSede = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSede.
     * 
     */
    public int getCodigoSede() {
        return codigoSede;
    }

    /**
     * Define el valor de la propiedad codigoSede.
     * 
     */
    public void setCodigoSede(int value) {
        this.codigoSede = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorSede.
     * 
     */
    public int getCreadorSede() {
        return creadorSede;
    }

    /**
     * Define el valor de la propiedad creadorSede.
     * 
     */
    public void setCreadorSede(int value) {
        this.creadorSede = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSede() {
        return estadoSede;
    }

    /**
     * Define el valor de la propiedad estadoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSede(String value) {
        this.estadoSede = value;
    }

    /**
     * Obtiene el valor de la propiedad idSede.
     * 
     */
    public int getIdSede() {
        return idSede;
    }

    /**
     * Define el valor de la propiedad idSede.
     * 
     */
    public void setIdSede(int value) {
        this.idSede = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSede() {
        return nombreSede;
    }

    /**
     * Define el valor de la propiedad nombreSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSede(String value) {
        this.nombreSede = value;
    }

}
