
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actulizarRutasResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actulizarRutasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://endpoint.siscomputo.com.co/}rutasEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actulizarRutasResponse", propOrder = {
    "_return"
})
public class ActulizarRutasResponse {

    @XmlElement(name = "return")
    protected RutasEntity _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link RutasEntity }
     *     
     */
    public RutasEntity getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link RutasEntity }
     *     
     */
    public void setReturn(RutasEntity value) {
        this._return = value;
    }

}
