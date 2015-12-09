
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioGrupoUsuarioEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioGrupoUsuarioEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="grupoUsuario" type="{http://endpoint.siscomputo.com.co/}grupoUsuariosEntity" minOccurs="0"/>
 *         &lt;element name="idUsuarioGrupoUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "usuarioGrupoUsuarioEntity", propOrder = {
    "grupoUsuario",
    "idUsuarioGrupoUsuario",
    "usuario"
})
public class UsuarioGrupoUsuarioEntity
    extends ObjetoRetornaEntity
{

    protected GrupoUsuariosEntity grupoUsuario;
    protected int idUsuarioGrupoUsuario;
    protected UsuarioEntity usuario;

    /**
     * Obtiene el valor de la propiedad grupoUsuario.
     * 
     * @return
     *     possible object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public GrupoUsuariosEntity getGrupoUsuario() {
        return grupoUsuario;
    }

    /**
     * Define el valor de la propiedad grupoUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public void setGrupoUsuario(GrupoUsuariosEntity value) {
        this.grupoUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioGrupoUsuario.
     * 
     */
    public int getIdUsuarioGrupoUsuario() {
        return idUsuarioGrupoUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuarioGrupoUsuario.
     * 
     */
    public void setIdUsuarioGrupoUsuario(int value) {
        this.idUsuarioGrupoUsuario = value;
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
