
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarCuentasProveedores complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarCuentasProveedores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CuentaProveedores" type="{http://endpoint.siscomputo.com.co/}cuentasProveedoresEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarCuentasProveedores", propOrder = {
    "cuentaProveedores"
})
public class InsertarCuentasProveedores {

    @XmlElement(name = "CuentaProveedores")
    protected CuentasProveedoresEntity cuentaProveedores;

    /**
     * Obtiene el valor de la propiedad cuentaProveedores.
     * 
     * @return
     *     possible object is
     *     {@link CuentasProveedoresEntity }
     *     
     */
    public CuentasProveedoresEntity getCuentaProveedores() {
        return cuentaProveedores;
    }

    /**
     * Define el valor de la propiedad cuentaProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentasProveedoresEntity }
     *     
     */
    public void setCuentaProveedores(CuentasProveedoresEntity value) {
        this.cuentaProveedores = value;
    }

}
