
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresarUsuarioMacroproceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresarUsuarioMacroproceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioMacroproceso" type="{http://endpoint.siscomputo.com.co/}usuarioMacroprocesoEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresarUsuarioMacroproceso", propOrder = {
    "usuarioMacroproceso"
})
public class IngresarUsuarioMacroproceso {

    protected List<UsuarioMacroprocesoEntity> usuarioMacroproceso;

    /**
     * Gets the value of the usuarioMacroproceso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarioMacroproceso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarioMacroproceso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioMacroprocesoEntity }
     * 
     * 
     */
    public List<UsuarioMacroprocesoEntity> getUsuarioMacroproceso() {
        if (usuarioMacroproceso == null) {
            usuarioMacroproceso = new ArrayList<UsuarioMacroprocesoEntity>();
        }
        return this.usuarioMacroproceso;
    }

}
