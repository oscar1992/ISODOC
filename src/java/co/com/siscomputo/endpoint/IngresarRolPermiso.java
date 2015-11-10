
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresarRolPermiso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresarRolPermiso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RolPermiso" type="{http://endpoint.siscomputo.com.co/}rolPermisoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresarRolPermiso", propOrder = {
    "rolPermiso"
})
public class IngresarRolPermiso {

    @XmlElement(name = "RolPermiso")
    protected RolPermisoEntity rolPermiso;

    /**
     * Obtiene el valor de la propiedad rolPermiso.
     * 
     * @return
     *     possible object is
     *     {@link RolPermisoEntity }
     *     
     */
    public RolPermisoEntity getRolPermiso() {
        return rolPermiso;
    }

    /**
     * Define el valor de la propiedad rolPermiso.
     * 
     * @param value
     *     allowed object is
     *     {@link RolPermisoEntity }
     *     
     */
    public void setRolPermiso(RolPermisoEntity value) {
        this.rolPermiso = value;
    }

}
