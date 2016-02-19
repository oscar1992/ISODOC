
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarTipoDocumento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarTipoDocumento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoDocmento" type="{http://endpoint.siscomputo.com.co/}tipoDocumentoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarTipoDocumento", propOrder = {
    "tipoDocmento"
})
public class ActualizarTipoDocumento {

    @XmlElement(name = "TipoDocmento")
    protected TipoDocumentoEntity tipoDocmento;

    /**
     * Obtiene el valor de la propiedad tipoDocmento.
     * 
     * @return
     *     possible object is
     *     {@link TipoDocumentoEntity }
     *     
     */
    public TipoDocumentoEntity getTipoDocmento() {
        return tipoDocmento;
    }

    /**
     * Define el valor de la propiedad tipoDocmento.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDocumentoEntity }
     *     
     */
    public void setTipoDocmento(TipoDocumentoEntity value) {
        this.tipoDocmento = value;
    }

}
