
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarTipoProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarTipoProveedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoProveedors" type="{http://endpoint.siscomputo.com.co/}tipoProveedorEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarTipoProveedor", propOrder = {
    "tipoProveedors"
})
public class InsertarTipoProveedor {

    @XmlElement(name = "TipoProveedors")
    protected TipoProveedorEntity tipoProveedors;

    /**
     * Obtiene el valor de la propiedad tipoProveedors.
     * 
     * @return
     *     possible object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public TipoProveedorEntity getTipoProveedors() {
        return tipoProveedors;
    }

    /**
     * Define el valor de la propiedad tipoProveedors.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public void setTipoProveedors(TipoProveedorEntity value) {
        this.tipoProveedors = value;
    }

}
