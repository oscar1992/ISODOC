
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para moduloEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="moduloEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_actualizador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_creador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_modulo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orden" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ruta_icono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruta_modulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moduloEntity", propOrder = {
    "estado",
    "idActualizador",
    "idCreador",
    "idModulo",
    "nombre",
    "orden",
    "rutaIcono",
    "rutaModulo"
})
public class ModuloEntity
    extends ObjetoTraza
{

    protected String estado;
    @XmlElement(name = "id_actualizador")
    protected int idActualizador;
    @XmlElement(name = "id_creador")
    protected int idCreador;
    @XmlElement(name = "id_modulo")
    protected int idModulo;
    protected String nombre;
    protected int orden;
    @XmlElement(name = "ruta_icono")
    protected String rutaIcono;
    @XmlElement(name = "ruta_modulo")
    protected String rutaModulo;

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
        return rutaIcono;
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

}
