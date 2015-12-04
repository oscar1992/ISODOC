
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioSubprocesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioSubprocesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="idAccion" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *         &lt;element name="idSubprocesoEntity" type="{http://endpoint.siscomputo.com.co/}subprocesoEntity" minOccurs="0"/>
 *         &lt;element name="idUsuario" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *         &lt;element name="idUsuarioSubproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioSubprocesoEntity", propOrder = {
    "idAccion",
    "idSubprocesoEntity",
    "idUsuario",
    "idUsuarioSubproceso"
})
public class UsuarioSubprocesoEntity
    extends ObjetoTraza
{

    protected AccionEntity idAccion;
    protected SubprocesoEntity idSubprocesoEntity;
    protected UsuarioEntity idUsuario;
    protected int idUsuarioSubproceso;

    /**
     * Obtiene el valor de la propiedad idAccion.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getIdAccion() {
        return idAccion;
    }

    /**
     * Define el valor de la propiedad idAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setIdAccion(AccionEntity value) {
        this.idAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad idSubprocesoEntity.
     * 
     * @return
     *     possible object is
     *     {@link SubprocesoEntity }
     *     
     */
    public SubprocesoEntity getIdSubprocesoEntity() {
        return idSubprocesoEntity;
    }

    /**
     * Define el valor de la propiedad idSubprocesoEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link SubprocesoEntity }
     *     
     */
    public void setIdSubprocesoEntity(SubprocesoEntity value) {
        this.idSubprocesoEntity = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setIdUsuario(UsuarioEntity value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioSubproceso.
     * 
     */
    public int getIdUsuarioSubproceso() {
        return idUsuarioSubproceso;
    }

    /**
     * Define el valor de la propiedad idUsuarioSubproceso.
     * 
     */
    public void setIdUsuarioSubproceso(int value) {
        this.idUsuarioSubproceso = value;
    }

}
