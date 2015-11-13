
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para menuPermisosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="menuPermisosEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="asociadoMenu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="asociadoNivel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_actualizador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_creador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_permiso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre_permiso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subNivel" type="{http://endpoint.siscomputo.com.co/}menuPermisosEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menuPermisosEntity", propOrder = {
    "asociadoMenu",
    "asociadoNivel",
    "estado",
    "idActualizador",
    "idCreador",
    "idPermiso",
    "nombrePermiso",
    "ruta",
    "subNivel"
})
public class MenuPermisosEntity {

    protected int asociadoMenu;
    protected int asociadoNivel;
    protected String estado;
    @XmlElement(name = "id_actualizador")
    protected int idActualizador;
    @XmlElement(name = "id_creador")
    protected int idCreador;
    @XmlElement(name = "id_permiso")
    protected int idPermiso;
    @XmlElement(name = "nombre_permiso")
    protected String nombrePermiso;
    protected String ruta;
    @XmlElement(nillable = true)
    protected List<MenuPermisosEntity> subNivel;

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

    /**
     * Gets the value of the subNivel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subNivel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubNivel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuPermisosEntity }
     * 
     * 
     */
    public List<MenuPermisosEntity> getSubNivel() {
        if (subNivel == null) {
            subNivel = new ArrayList<MenuPermisosEntity>();
        }
        return this.subNivel;
    }

}
