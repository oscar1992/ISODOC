
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarLinea complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarLinea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LineaObjeto" type="{http://endpoint.siscomputo.com.co/}lineaEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarLinea", propOrder = {
    "lineaObjeto"
})
public class ActualizarLinea {

    @XmlElement(name = "LineaObjeto")
    protected LineaEntity lineaObjeto;

    /**
     * Obtiene el valor de la propiedad lineaObjeto.
     * 
     * @return
     *     possible object is
     *     {@link LineaEntity }
     *     
     */
    public LineaEntity getLineaObjeto() {
        return lineaObjeto;
    }

    /**
     * Define el valor de la propiedad lineaObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link LineaEntity }
     *     
     */
    public void setLineaObjeto(LineaEntity value) {
        this.lineaObjeto = value;
    }

}
