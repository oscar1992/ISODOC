
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresarUsuarioSubproceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresarUsuarioSubproceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UsuarioSubproceso" type="{http://endpoint.siscomputo.com.co/}usuarioSubprocesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresarUsuarioSubproceso", propOrder = {
    "usuarioSubproceso"
})
public class IngresarUsuarioSubproceso {

    @XmlElement(name = "UsuarioSubproceso")
    protected UsuarioSubprocesoEntity usuarioSubproceso;

    /**
     * Obtiene el valor de la propiedad usuarioSubproceso.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioSubprocesoEntity }
     *     
     */
    public UsuarioSubprocesoEntity getUsuarioSubproceso() {
        return usuarioSubproceso;
    }

    /**
     * Define el valor de la propiedad usuarioSubproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioSubprocesoEntity }
     *     
     */
    public void setUsuarioSubproceso(UsuarioSubprocesoEntity value) {
        this.usuarioSubproceso = value;
    }

}
