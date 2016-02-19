
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarAnexoProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarAnexoProveedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnexoProveedores" type="{http://endpoint.siscomputo.com.co/}anexoProveedorEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarAnexoProveedor", propOrder = {
    "anexoProveedores"
})
public class InsertarAnexoProveedor {

    @XmlElement(name = "AnexoProveedores")
    protected AnexoProveedorEntity anexoProveedores;

    /**
     * Obtiene el valor de la propiedad anexoProveedores.
     * 
     * @return
     *     possible object is
     *     {@link AnexoProveedorEntity }
     *     
     */
    public AnexoProveedorEntity getAnexoProveedores() {
        return anexoProveedores;
    }

    /**
     * Define el valor de la propiedad anexoProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link AnexoProveedorEntity }
     *     
     */
    public void setAnexoProveedores(AnexoProveedorEntity value) {
        this.anexoProveedores = value;
    }

}
