
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para lineaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lineaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoLinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idLinea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoLinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaEntity", propOrder = {
    "estadoLinea",
    "idLinea",
    "tipoLinea"
})
public class LineaEntity
    extends ObjetoRetornaEntity
{

    protected String estadoLinea;
    protected int idLinea;
    protected String tipoLinea;

    /**
     * Obtiene el valor de la propiedad estadoLinea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoLinea() {
        return estadoLinea;
    }

    /**
     * Define el valor de la propiedad estadoLinea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoLinea(String value) {
        this.estadoLinea = value;
    }

    /**
     * Obtiene el valor de la propiedad idLinea.
     * 
     */
    public int getIdLinea() {
        return idLinea;
    }

    /**
     * Define el valor de la propiedad idLinea.
     * 
     */
    public void setIdLinea(int value) {
        this.idLinea = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoLinea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoLinea() {
        return tipoLinea;
    }

    /**
     * Define el valor de la propiedad tipoLinea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoLinea(String value) {
        this.tipoLinea = value;
    }

}
