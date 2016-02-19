
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarTipoTributario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarTipoTributario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoTributarioObjeto" type="{http://endpoint.siscomputo.com.co/}tipoTributarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarTipoTributario", propOrder = {
    "tipoTributarioObjeto"
})
public class InsertarTipoTributario {

    @XmlElement(name = "TipoTributarioObjeto")
    protected TipoTributarioEntity tipoTributarioObjeto;

    /**
     * Obtiene el valor de la propiedad tipoTributarioObjeto.
     * 
     * @return
     *     possible object is
     *     {@link TipoTributarioEntity }
     *     
     */
    public TipoTributarioEntity getTipoTributarioObjeto() {
        return tipoTributarioObjeto;
    }

    /**
     * Define el valor de la propiedad tipoTributarioObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTributarioEntity }
     *     
     */
    public void setTipoTributarioObjeto(TipoTributarioEntity value) {
        this.tipoTributarioObjeto = value;
    }

}
