
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaAsignaPermisosModulo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaAsignaPermisosModulo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="modulo" type="{http://endpoint.siscomputo.com.co/}moduloEntity" minOccurs="0"/>
 *         &lt;element name="permisoNivel1" type="{http://endpoint.siscomputo.com.co/}listaAsignaPermisosPermiso" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaAsignaPermisosModulo", propOrder = {
    "modulo",
    "permisoNivel1"
})
public class ListaAsignaPermisosModulo
    extends ObjetoTraza
{

    protected ModuloEntity modulo;
    @XmlElement(nillable = true)
    protected List<ListaAsignaPermisosPermiso> permisoNivel1;

    /**
     * Obtiene el valor de la propiedad modulo.
     * 
     * @return
     *     possible object is
     *     {@link ModuloEntity }
     *     
     */
    public ModuloEntity getModulo() {
        return modulo;
    }

    /**
     * Define el valor de la propiedad modulo.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuloEntity }
     *     
     */
    public void setModulo(ModuloEntity value) {
        this.modulo = value;
    }

    /**
     * Gets the value of the permisoNivel1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permisoNivel1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermisoNivel1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaAsignaPermisosPermiso }
     * 
     * 
     */
    public List<ListaAsignaPermisosPermiso> getPermisoNivel1() {
        if (permisoNivel1 == null) {
            permisoNivel1 = new ArrayList<ListaAsignaPermisosPermiso>();
        }
        return this.permisoNivel1;
    }

}
