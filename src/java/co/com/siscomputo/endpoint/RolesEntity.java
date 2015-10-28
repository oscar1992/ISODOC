
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rolesEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rolesEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="estado_rol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_actualizador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_creador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_rol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre_rol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rolesEntity", propOrder = {
    "estadoRol",
    "idActualizador",
    "idCreador",
    "idRol",
    "nombreRol"
})
public class RolesEntity
    extends ObjetoTraza
{

    @XmlElement(name = "estado_rol")
    protected String estadoRol;
    @XmlElement(name = "id_actualizador")
    protected int idActualizador;
    @XmlElement(name = "id_creador")
    protected int idCreador;
    @XmlElement(name = "id_rol")
    protected int idRol;
    @XmlElement(name = "nombre_rol")
    protected String nombreRol;

    /**
     * Obtiene el valor de la propiedad estadoRol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoRol() {
        return estadoRol;
    }

    /**
     * Define el valor de la propiedad estadoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoRol(String value) {
        this.estadoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad idActualizador.
     * 
     */
    public int getIdActualizador() {
        return idActualizador;
    }

    /**
     * Define el valor de la propiedad idActualizador.
     * 
     */
    public void setIdActualizador(int value) {
        this.idActualizador = value;
    }

    /**
     * Obtiene el valor de la propiedad idCreador.
     * 
     */
    public int getIdCreador() {
        return idCreador;
    }

    /**
     * Define el valor de la propiedad idCreador.
     * 
     */
    public void setIdCreador(int value) {
        this.idCreador = value;
    }

    /**
     * Obtiene el valor de la propiedad idRol.
     * 
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * Define el valor de la propiedad idRol.
     * 
     */
    public void setIdRol(int value) {
        this.idRol = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreRol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Define el valor de la propiedad nombreRol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRol(String value) {
        this.nombreRol = value;
    }

}
