
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rolPermisoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rolPermisoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="id_permiso" type="{http://endpoint.siscomputo.com.co/}permisosEntity" minOccurs="0"/>
 *         &lt;element name="id_rol" type="{http://endpoint.siscomputo.com.co/}rolesEntity" minOccurs="0"/>
 *         &lt;element name="id_rol_permiso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rolPermisoEntity", propOrder = {
    "idPermiso",
    "idRol",
    "idRolPermiso"
})
public class RolPermisoEntity
    extends ObjetoTraza
{

    @XmlElement(name = "id_permiso")
    protected PermisosEntity idPermiso;
    @XmlElement(name = "id_rol")
    protected RolesEntity idRol;
    @XmlElement(name = "id_rol_permiso")
    protected int idRolPermiso;

    /**
     * Obtiene el valor de la propiedad idPermiso.
     * 
     * @return
     *     possible object is
     *     {@link PermisosEntity }
     *     
     */
    public PermisosEntity getIdPermiso() {
        return idPermiso;
    }

    /**
     * Define el valor de la propiedad idPermiso.
     * 
     * @param value
     *     allowed object is
     *     {@link PermisosEntity }
     *     
     */
    public void setIdPermiso(PermisosEntity value) {
        this.idPermiso = value;
    }

    /**
     * Obtiene el valor de la propiedad idRol.
     * 
     * @return
     *     possible object is
     *     {@link RolesEntity }
     *     
     */
    public RolesEntity getIdRol() {
        return idRol;
    }

    /**
     * Define el valor de la propiedad idRol.
     * 
     * @param value
     *     allowed object is
     *     {@link RolesEntity }
     *     
     */
    public void setIdRol(RolesEntity value) {
        this.idRol = value;
    }

    /**
     * Obtiene el valor de la propiedad idRolPermiso.
     * 
     */
    public int getIdRolPermiso() {
        return idRolPermiso;
    }

    /**
     * Define el valor de la propiedad idRolPermiso.
     * 
     */
    public void setIdRolPermiso(int value) {
        this.idRolPermiso = value;
    }

}
