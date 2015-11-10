
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarUsuarioRol complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarUsuarioRol">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioRol" type="{http://endpoint.siscomputo.com.co/}usuarioRolEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarUsuarioRol", propOrder = {
    "usuarioRol"
})
public class ActualizarUsuarioRol {

    protected UsuarioRolEntity usuarioRol;

    /**
     * Obtiene el valor de la propiedad usuarioRol.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioRolEntity }
     *     
     */
    public UsuarioRolEntity getUsuarioRol() {
        return usuarioRol;
    }

    /**
     * Define el valor de la propiedad usuarioRol.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioRolEntity }
     *     
     */
    public void setUsuarioRol(UsuarioRolEntity value) {
        this.usuarioRol = value;
    }

}
