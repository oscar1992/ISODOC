
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarTipoCuenta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarTipoCuenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoCuentaObjeto" type="{http://endpoint.siscomputo.com.co/}tipoCuentaEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarTipoCuenta", propOrder = {
    "tipoCuentaObjeto"
})
public class ActualizarTipoCuenta {

    @XmlElement(name = "TipoCuentaObjeto")
    protected TipoCuentaEntity tipoCuentaObjeto;

    /**
     * Obtiene el valor de la propiedad tipoCuentaObjeto.
     * 
     * @return
     *     possible object is
     *     {@link TipoCuentaEntity }
     *     
     */
    public TipoCuentaEntity getTipoCuentaObjeto() {
        return tipoCuentaObjeto;
    }

    /**
     * Define el valor de la propiedad tipoCuentaObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCuentaEntity }
     *     
     */
    public void setTipoCuentaObjeto(TipoCuentaEntity value) {
        this.tipoCuentaObjeto = value;
    }

}
