
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para menuModuloEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="menuModuloEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idActualizador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCreador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idModulo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orden" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rutaIcono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutaModulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "menuModuloEntity", propOrder = {
    "estado",
    "idActualizador",
    "idCreador",
    "idModulo",
    "nombre",
    "orden",
    "rutaIcono",
    "rutaModulo",
    "subNivel"
})
public class MenuModuloEntity {

    protected String estado;
    protected int idActualizador;
    protected int idCreador;
    protected int idModulo;
    protected String nombre;
    protected int orden;
    protected String rutaIcono;
    protected String rutaModulo;
    @XmlElement(nillable = true)
    protected List<MenuPermisosEntity> subNivel;

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
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * Define el valor de la propiedad idModulo.
     * 
     */
    public void setIdModulo(int value) {
        this.idModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad orden.
     * 
     */
    public int getOrden() {
        return orden;
    }

    /**
     * Define el valor de la propiedad orden.
     * 
     */
    public void setOrden(int value) {
        this.orden = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaIcono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaIcono() {
        return rutaIconoCambio(rutaIcono);
        //return rutaIcono;
    }

    public String rutaIconoCambio(String ruta) {
        try {
            int numeroModulo=-1;
            try {
                numeroModulo = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroModulo");
                //System.out.println("nn: "+numeroModulo);
            } catch (Exception e) {
                //System.out.println("??");
                numeroModulo = -1;
            }
            String modulos = "modulos" + numeroModulo;
            String rte = ruta.replace("modulos2", modulos);
            //System.out.println("RTE: "+modulos);
            //System.out.println("RUTAX: " + rte);
            return rte;
        } catch (Exception e) {
            System.out.println("EXCEP2");
            return ruta;
        }
    }

    /**
     * Define el valor de la propiedad rutaIcono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaIcono(String value) {
        this.rutaIcono = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaModulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaModulo() {
        return rutaModulo;
    }

    /**
     * Define el valor de la propiedad rutaModulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaModulo(String value) {
        this.rutaModulo = value;
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
