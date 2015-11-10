
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioRolEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioRolEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://endpoint.siscomputo.com.co/}areaEntity" minOccurs="0"/>
 *         &lt;element name="id_usuario_rol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rol" type="{http://endpoint.siscomputo.com.co/}rolesEntity" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioRolEntity", propOrder = {
    "area",
    "idUsuarioRol",
    "rol",
    "usuario"
})
public class UsuarioRolEntity
    extends ObjetoTraza
{

    protected AreaEntity area;
    @XmlElement(name = "id_usuario_rol")
    protected int idUsuarioRol;
    protected RolesEntity rol;
    protected UsuarioEntity usuario;

    /**
     * Obtiene el valor de la propiedad area.
     * 
     * @return
     *     possible object is
     *     {@link AreaEntity }
     *     
     */
    public AreaEntity getArea() {
        return area;
    }

    /**
     * Define el valor de la propiedad area.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaEntity }
     *     
     */
    public void setArea(AreaEntity value) {
        this.area = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioRol.
     * 
     */
    public int getIdUsuarioRol() {
        return idUsuarioRol;
    }

    /**
     * Define el valor de la propiedad idUsuarioRol.
     * 
     */
    public void setIdUsuarioRol(int value) {
        this.idUsuarioRol = value;
    }

    /**
     * Obtiene el valor de la propiedad rol.
     * 
     * @return
     *     possible object is
     *     {@link RolesEntity }
     *     
     */
    public RolesEntity getRol() {
        return rol;
    }

    /**
     * Define el valor de la propiedad rol.
     * 
     * @param value
     *     allowed object is
     *     {@link RolesEntity }
     *     
     */
    public void setRol(RolesEntity value) {
        this.rol = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuario(UsuarioEntity value) {
        this.usuario = value;
    }

}
