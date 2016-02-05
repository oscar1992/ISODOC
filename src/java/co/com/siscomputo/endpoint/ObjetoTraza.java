
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para objetoTraza complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="objetoTraza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroRespuesta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="trazaRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetoTraza", propOrder = {
    "numeroRespuesta",
    "trazaRespuesta"
})
@XmlSeeAlso({
    ObjetoRetornaEntity.class
})
public class ObjetoTraza {

    protected int numeroRespuesta;
    protected String trazaRespuesta;

    /**
     * Obtiene el valor de la propiedad numeroRespuesta.
     * 
     */
    public int getNumeroRespuesta() {
        return numeroRespuesta;
    }

    /**
     * Define el valor de la propiedad numeroRespuesta.
     * 
     */
    public void setNumeroRespuesta(int value) {
        this.numeroRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad trazaRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrazaRespuesta() {
        return trazaRespuesta;
    }

    /**
     * Define el valor de la propiedad trazaRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrazaRespuesta(String value) {
        this.trazaRespuesta = value;
    }

}
