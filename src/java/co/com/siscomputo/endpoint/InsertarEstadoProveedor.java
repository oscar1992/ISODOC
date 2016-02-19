
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarEstadoProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarEstadoProveedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProveedorObjeto" type="{http://endpoint.siscomputo.com.co/}estadoProveedorEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarEstadoProveedor", propOrder = {
    "proveedorObjeto"
})
public class InsertarEstadoProveedor {

    @XmlElement(name = "ProveedorObjeto")
    protected EstadoProveedorEntity proveedorObjeto;

    /**
     * Obtiene el valor de la propiedad proveedorObjeto.
     * 
     * @return
     *     possible object is
     *     {@link EstadoProveedorEntity }
     *     
     */
    public EstadoProveedorEntity getProveedorObjeto() {
        return proveedorObjeto;
    }

    /**
     * Define el valor de la propiedad proveedorObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoProveedorEntity }
     *     
     */
    public void setProveedorObjeto(EstadoProveedorEntity value) {
        this.proveedorObjeto = value;
    }

}
