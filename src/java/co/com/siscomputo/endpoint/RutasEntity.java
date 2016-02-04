
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rutasEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rutasEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="carpetaRutas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idRutas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoRutas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rutasEntity", propOrder = {
    "carpetaRutas",
    "idRutas",
    "tipoRutas"
})
public class RutasEntity
    extends ObjetoTraza
{

    protected String carpetaRutas;
    protected int idRutas;
    protected String tipoRutas;

    /**
     * Obtiene el valor de la propiedad carpetaRutas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarpetaRutas() {
        return carpetaRutas;
    }

    /**
     * Define el valor de la propiedad carpetaRutas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarpetaRutas(String value) {
        this.carpetaRutas = value;
    }

    /**
     * Obtiene el valor de la propiedad idRutas.
     * 
     */
    public int getIdRutas() {
        return idRutas;
    }

    /**
     * Define el valor de la propiedad idRutas.
     * 
     */
    public void setIdRutas(int value) {
        this.idRutas = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoRutas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRutas() {
        return tipoRutas;
    }

    /**
     * Define el valor de la propiedad tipoRutas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRutas(String value) {
        this.tipoRutas = value;
    }

}
