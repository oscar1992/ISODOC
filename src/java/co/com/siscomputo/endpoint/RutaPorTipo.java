
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rutaPorTipo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rutaPorTipo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rutas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rutaPorTipo", propOrder = {
    "rutas"
})
public class RutaPorTipo {

    protected String rutas;

    /**
     * Obtiene el valor de la propiedad rutas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutas() {
        return rutas;
    }

    /**
     * Define el valor de la propiedad rutas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutas(String value) {
        this.rutas = value;
    }

}
