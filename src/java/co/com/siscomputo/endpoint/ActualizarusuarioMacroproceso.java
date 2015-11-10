
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarusuarioMacroproceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarusuarioMacroproceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioMacroproceso" type="{http://endpoint.siscomputo.com.co/}usuarioMacroprocesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarusuarioMacroproceso", propOrder = {
    "usuarioMacroproceso"
})
public class ActualizarusuarioMacroproceso {

    protected UsuarioMacroprocesoEntity usuarioMacroproceso;

    /**
     * Obtiene el valor de la propiedad usuarioMacroproceso.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioMacroprocesoEntity }
     *     
     */
    public UsuarioMacroprocesoEntity getUsuarioMacroproceso() {
        return usuarioMacroproceso;
    }

    /**
     * Define el valor de la propiedad usuarioMacroproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioMacroprocesoEntity }
     *     
     */
    public void setUsuarioMacroproceso(UsuarioMacroprocesoEntity value) {
        this.usuarioMacroproceso = value;
    }

}
