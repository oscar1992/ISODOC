
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarUsuarioProceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarUsuarioProceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioProceso" type="{http://endpoint.siscomputo.com.co/}usuarioProcesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarUsuarioProceso", propOrder = {
    "usuarioProceso"
})
public class ActualizarUsuarioProceso {

    protected UsuarioProcesoEntity usuarioProceso;

    /**
     * Obtiene el valor de la propiedad usuarioProceso.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioProcesoEntity }
     *     
     */
    public UsuarioProcesoEntity getUsuarioProceso() {
        return usuarioProceso;
    }

    /**
     * Define el valor de la propiedad usuarioProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioProcesoEntity }
     *     
     */
    public void setUsuarioProceso(UsuarioProcesoEntity value) {
        this.usuarioProceso = value;
    }

}
