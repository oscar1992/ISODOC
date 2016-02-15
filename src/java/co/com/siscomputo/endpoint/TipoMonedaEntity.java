
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoMonedaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoMonedaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoMoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMoneda" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoMoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorMoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoMonedaEntity", propOrder = {
    "estadoMoneda",
    "idMoneda",
    "tipoMoneda",
    "valorMoneda"
})
public class TipoMonedaEntity
    extends ObjetoRetornaEntity
{

    protected String estadoMoneda;
    protected Integer idMoneda;
    protected String tipoMoneda;
    protected String valorMoneda;

    /**
     * Obtiene el valor de la propiedad estadoMoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoMoneda() {
        return estadoMoneda;
    }

    /**
     * Define el valor de la propiedad estadoMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoMoneda(String value) {
        this.estadoMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad idMoneda.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdMoneda() {
        return idMoneda;
    }

    /**
     * Define el valor de la propiedad idMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdMoneda(Integer value) {
        this.idMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoMoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMoneda() {
        return tipoMoneda;
    }

    /**
     * Define el valor de la propiedad tipoMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMoneda(String value) {
        this.tipoMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad valorMoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorMoneda() {
        return valorMoneda;
    }

    /**
     * Define el valor de la propiedad valorMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorMoneda(String value) {
        this.valorMoneda = value;
    }

}
