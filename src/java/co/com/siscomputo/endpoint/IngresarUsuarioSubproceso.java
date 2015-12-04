
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="UsuarioSubproceso" type="{http://endpoint.siscomputo.com.co/}usuarioSubprocesoEntity" maxOccurs="unbounded" minOccurs="0"/>
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
    protected List<UsuarioSubprocesoEntity> usuarioSubproceso;

    /**
     * Gets the value of the usuarioSubproceso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarioSubproceso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarioSubproceso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioSubprocesoEntity }
     * 
     * 
     */
    public List<UsuarioSubprocesoEntity> getUsuarioSubproceso() {
        if (usuarioSubproceso == null) {
            usuarioSubproceso = new ArrayList<UsuarioSubprocesoEntity>();
        }
        return this.usuarioSubproceso;
    }

}
