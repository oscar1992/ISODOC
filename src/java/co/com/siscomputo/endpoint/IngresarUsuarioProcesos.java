
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresarUsuarioProcesos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresarUsuarioProcesos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UsuarioProceso" type="{http://endpoint.siscomputo.com.co/}usuarioProcesoEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresarUsuarioProcesos", propOrder = {
    "usuarioProceso"
})
public class IngresarUsuarioProcesos {

    @XmlElement(name = "UsuarioProceso")
    protected List<UsuarioProcesoEntity> usuarioProceso;

    /**
     * Gets the value of the usuarioProceso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarioProceso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarioProceso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioProcesoEntity }
     * 
     * 
     */
    public List<UsuarioProcesoEntity> getUsuarioProceso() {
        if (usuarioProceso == null) {
            usuarioProceso = new ArrayList<UsuarioProcesoEntity>();
        }
        return this.usuarioProceso;
    }

}
