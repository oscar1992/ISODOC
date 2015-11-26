
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarDisposicion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarDisposicion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disposicion" type="{http://endpoint.siscomputo.com.co/}disposicionesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarDisposicion", propOrder = {
    "disposicion"
})
public class ActualizarDisposicion {

    protected DisposicionesEntity disposicion;

    /**
     * Obtiene el valor de la propiedad disposicion.
     * 
     * @return
     *     possible object is
     *     {@link DisposicionesEntity }
     *     
     */
    public DisposicionesEntity getDisposicion() {
        return disposicion;
    }

    /**
     * Define el valor de la propiedad disposicion.
     * 
     * @param value
     *     allowed object is
     *     {@link DisposicionesEntity }
     *     
     */
    public void setDisposicion(DisposicionesEntity value) {
        this.disposicion = value;
    }

}
