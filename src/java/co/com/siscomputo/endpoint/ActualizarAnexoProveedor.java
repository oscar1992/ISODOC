
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarAnexoProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarAnexoProveedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnexoProveedor" type="{http://endpoint.siscomputo.com.co/}anexoProveedorEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarAnexoProveedor", propOrder = {
    "anexoProveedor"
})
public class ActualizarAnexoProveedor {

    @XmlElement(name = "AnexoProveedor")
    protected AnexoProveedorEntity anexoProveedor;

    /**
     * Obtiene el valor de la propiedad anexoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link AnexoProveedorEntity }
     *     
     */
    public AnexoProveedorEntity getAnexoProveedor() {
        return anexoProveedor;
    }

    /**
     * Define el valor de la propiedad anexoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link AnexoProveedorEntity }
     *     
     */
    public void setAnexoProveedor(AnexoProveedorEntity value) {
        this.anexoProveedor = value;
    }

}
