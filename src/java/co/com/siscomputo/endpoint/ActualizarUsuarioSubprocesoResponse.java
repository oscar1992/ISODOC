
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarUsuarioSubprocesoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarUsuarioSubprocesoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://endpoint.siscomputo.com.co/}usuarioSubprocesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarUsuarioSubprocesoResponse", propOrder = {
    "_return"
})
public class ActualizarUsuarioSubprocesoResponse {

    @XmlElement(name = "return")
    protected UsuarioSubprocesoEntity _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioSubprocesoEntity }
     *     
     */
    public UsuarioSubprocesoEntity getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioSubprocesoEntity }
     *     
     */
    public void setReturn(UsuarioSubprocesoEntity value) {
        this._return = value;
    }

}
