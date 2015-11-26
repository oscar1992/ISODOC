
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarTipoDocumental complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarTipoDocumental">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tiposd" type="{http://endpoint.siscomputo.com.co/}tiposDocumentalesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarTipoDocumental", propOrder = {
    "tiposd"
})
public class ActualizarTipoDocumental {

    protected TiposDocumentalesEntity tiposd;

    /**
     * Obtiene el valor de la propiedad tiposd.
     * 
     * @return
     *     possible object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public TiposDocumentalesEntity getTiposd() {
        return tiposd;
    }

    /**
     * Define el valor de la propiedad tiposd.
     * 
     * @param value
     *     allowed object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public void setTiposd(TiposDocumentalesEntity value) {
        this.tiposd = value;
    }

}
