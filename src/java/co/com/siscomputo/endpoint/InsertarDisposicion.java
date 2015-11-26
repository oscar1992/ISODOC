
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarDisposicion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarDisposicion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disopsicion" type="{http://endpoint.siscomputo.com.co/}disposicionesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarDisposicion", propOrder = {
    "disopsicion"
})
public class InsertarDisposicion {

    protected DisposicionesEntity disopsicion;

    /**
     * Obtiene el valor de la propiedad disopsicion.
     * 
     * @return
     *     possible object is
     *     {@link DisposicionesEntity }
     *     
     */
    public DisposicionesEntity getDisopsicion() {
        return disopsicion;
    }

    /**
     * Define el valor de la propiedad disopsicion.
     * 
     * @param value
     *     allowed object is
     *     {@link DisposicionesEntity }
     *     
     */
    public void setDisopsicion(DisposicionesEntity value) {
        this.disopsicion = value;
    }

}
