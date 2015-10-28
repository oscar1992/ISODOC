
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para permisosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="permisosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="asociadoMenu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="asociadoNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_actualizador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_creador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_modulo" type="{http://endpoint.siscomputo.com.co/}moduloEntity" minOccurs="0"/>
 *         &lt;element name="id_permiso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre_permiso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permisosEntity", propOrder = {
    "asociadoMenu",
    "asociadoNivel",
    "estado",
    "idActualizador",
    "idCreador",
    "idModulo",
    "idPermiso",
    "nombrePermiso",
    "ruta"
})
public class PermisosEntity
    extends ObjetoTraza
{

    protected int asociadoMenu;
    protected int asociadoNivel;
    protected String estado;
    @XmlElement(name = "id_actualizador")
    protected int idActualizador;
    @XmlElement(name = "id_creador")
    protected int idCreador;
    @XmlElement(name = "id_modulo")
    protected ModuloEntity idModulo;
    @XmlElement(name = "id_permiso")
    protected int idPermiso;
    @XmlElement(name = "nombre_permiso")
    protected String nombrePermiso;
    protected String ruta;

    /**
     * Obtiene el valor de la propiedad asociadoMenu.
     * 
     */
    public int getAsociadoMenu() {
        return asociadoMenu;
    }

    /**
     * Define el valor de la propiedad asociadoMenu.
     * 
     */
    public void setAsociadoMenu(int value) {
        this.asociadoMenu = value;
    }

    /**
     * Obtiene el valor de la propiedad asociadoNivel.
     * 
     */
    public int getAsociadoNivel() {
        return asociadoNivel;
    }

    /**
     * Define el valor de la propiedad asociadoNivel.
     * 
     */
    public void setAsociadoNivel(int value) {
        this.asociadoNivel = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
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
     * Obtiene el valor de la propiedad idModulo.
     * 
     * @return
     *     possible object is
     *     {@link ModuloEntity }
     *     
     */
    public ModuloEntity getIdModulo() {
        return idModulo;
    }

    /**
     * Define el valor de la propiedad idModulo.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuloEntity }
     *     
     */
    public void setIdModulo(ModuloEntity value) {
        this.idModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad idPermiso.
     * 
     */
    public int getIdPermiso() {
        return idPermiso;
    }

    /**
     * Define el valor de la propiedad idPermiso.
     * 
     */
    public void setIdPermiso(int value) {
        this.idPermiso = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePermiso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePermiso() {
        return nombrePermiso;
    }

    /**
     * Define el valor de la propiedad nombrePermiso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePermiso(String value) {
        this.nombrePermiso = value;
    }

    /**
     * Obtiene el valor de la propiedad ruta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Define el valor de la propiedad ruta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

}
