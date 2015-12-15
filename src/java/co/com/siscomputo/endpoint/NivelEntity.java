
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para nivelEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="nivelEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoNivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreNivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuenciaNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nivelEntity", propOrder = {
    "actualizadorNivel",
    "creadorNivel",
    "estadoNivel",
    "idNivel",
    "nombreNivel",
    "secuenciaNivel"
})
public class NivelEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorNivel;
    protected int creadorNivel;
    protected String estadoNivel;
    protected int idNivel;
    protected String nombreNivel;
    protected int secuenciaNivel;

    /**
     * Obtiene el valor de la propiedad actualizadorNivel.
     * 
     */
    public int getActualizadorNivel() {
        return actualizadorNivel;
    }

    /**
     * Define el valor de la propiedad actualizadorNivel.
     * 
     */
    public void setActualizadorNivel(int value) {
        this.actualizadorNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorNivel.
     * 
     */
    public int getCreadorNivel() {
        return creadorNivel;
    }

    /**
     * Define el valor de la propiedad creadorNivel.
     * 
     */
    public void setCreadorNivel(int value) {
        this.creadorNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoNivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNivel() {
        return estadoNivel;
    }

    /**
     * Define el valor de la propiedad estadoNivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNivel(String value) {
        this.estadoNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad idNivel.
     * 
     */
    public int getIdNivel() {
        return idNivel;
    }

    /**
     * Define el valor de la propiedad idNivel.
     * 
     */
    public void setIdNivel(int value) {
        this.idNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreNivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreNivel() {
        return nombreNivel;
    }

    /**
     * Define el valor de la propiedad nombreNivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreNivel(String value) {
        this.nombreNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad secuenciaNivel.
     * 
     */
    public int getSecuenciaNivel() {
        return secuenciaNivel;
    }

    /**
     * Define el valor de la propiedad secuenciaNivel.
     * 
     */
    public void setSecuenciaNivel(int value) {
        this.secuenciaNivel = value;
    }

}
