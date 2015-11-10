
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaAsignaPermisosPermiso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaAsignaPermisosPermiso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaS" type="{http://endpoint.siscomputo.com.co/}listaAsignaPermisosPermiso" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="permiso" type="{http://endpoint.siscomputo.com.co/}permisosEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaAsignaPermisosPermiso", propOrder = {
    "listaS",
    "permiso"
})
public class ListaAsignaPermisosPermiso {

    @XmlElement(nillable = true)
    protected List<ListaAsignaPermisosPermiso> listaS;
    protected PermisosEntity permiso;

    /**
     * Gets the value of the listaS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaAsignaPermisosPermiso }
     * 
     * 
     */
    public List<ListaAsignaPermisosPermiso> getListaS() {
        if (listaS == null) {
            listaS = new ArrayList<ListaAsignaPermisosPermiso>();
        }
        return this.listaS;
    }

    /**
     * Obtiene el valor de la propiedad permiso.
     * 
     * @return
     *     possible object is
     *     {@link PermisosEntity }
     *     
     */
    public PermisosEntity getPermiso() {
        return permiso;
    }

    /**
     * Define el valor de la propiedad permiso.
     * 
     * @param value
     *     allowed object is
     *     {@link PermisosEntity }
     *     
     */
    public void setPermiso(PermisosEntity value) {
        this.permiso = value;
    }

}
