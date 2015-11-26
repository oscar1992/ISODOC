
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarTiposDocumetalesResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarTiposDocumetalesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://endpoint.siscomputo.com.co/}tiposDocumentalesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarTiposDocumetalesResponse", propOrder = {
    "_return"
})
public class InsertarTiposDocumetalesResponse {

    @XmlElement(name = "return")
    protected TiposDocumentalesEntity _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public TiposDocumentalesEntity getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public void setReturn(TiposDocumentalesEntity value) {
        this._return = value;
    }

}
