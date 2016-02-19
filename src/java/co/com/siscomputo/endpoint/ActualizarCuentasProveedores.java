
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarCuentasProveedores complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarCuentasProveedores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CuentaProveedoresObjeto" type="{http://endpoint.siscomputo.com.co/}cuentasProveedoresEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarCuentasProveedores", propOrder = {
    "cuentaProveedoresObjeto"
})
public class ActualizarCuentasProveedores {

    @XmlElement(name = "CuentaProveedoresObjeto")
    protected CuentasProveedoresEntity cuentaProveedoresObjeto;

    /**
     * Obtiene el valor de la propiedad cuentaProveedoresObjeto.
     * 
     * @return
     *     possible object is
     *     {@link CuentasProveedoresEntity }
     *     
     */
    public CuentasProveedoresEntity getCuentaProveedoresObjeto() {
        return cuentaProveedoresObjeto;
    }

    /**
     * Define el valor de la propiedad cuentaProveedoresObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentasProveedoresEntity }
     *     
     */
    public void setCuentaProveedoresObjeto(CuentasProveedoresEntity value) {
        this.cuentaProveedoresObjeto = value;
    }

}
