
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarMetodoRecuperacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarMetodoRecuperacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metodo" type="{http://endpoint.siscomputo.com.co/}metodoRecuperacionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarMetodoRecuperacion", propOrder = {
    "metodo"
})
public class InsertarMetodoRecuperacion {

    protected MetodoRecuperacionEntity metodo;

    /**
     * Obtiene el valor de la propiedad metodo.
     * 
     * @return
     *     possible object is
     *     {@link MetodoRecuperacionEntity }
     *     
     */
    public MetodoRecuperacionEntity getMetodo() {
        return metodo;
    }

    /**
     * Define el valor de la propiedad metodo.
     * 
     * @param value
     *     allowed object is
     *     {@link MetodoRecuperacionEntity }
     *     
     */
    public void setMetodo(MetodoRecuperacionEntity value) {
        this.metodo = value;
    }

}
