
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizaMacroProceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizaMacroProceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="macro" type="{http://endpoint.siscomputo.com.co/}macroprocesosEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizaMacroProceso", propOrder = {
    "macro"
})
public class ActualizaMacroProceso {

    protected MacroprocesosEntity macro;

    /**
     * Obtiene el valor de la propiedad macro.
     * 
     * @return
     *     possible object is
     *     {@link MacroprocesosEntity }
     *     
     */
    public MacroprocesosEntity getMacro() {
        return macro;
    }

    /**
     * Define el valor de la propiedad macro.
     * 
     * @param value
     *     allowed object is
     *     {@link MacroprocesosEntity }
     *     
     */
    public void setMacro(MacroprocesosEntity value) {
        this.macro = value;
    }

}
