
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ciudadEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ciudadEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorCiudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ciudadDepartamento" type="{http://endpoint.siscomputo.com.co/}departamentoEntity" minOccurs="0"/>
 *         &lt;element name="codigoCiudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorCiudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoCiudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCiudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreCiudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ciudadEntity", propOrder = {
    "actualizadorCiudad",
    "ciudadDepartamento",
    "codigoCiudad",
    "creadorCiudad",
    "estadoCiudad",
    "idCiudad",
    "nombreCiudad"
})
public class CiudadEntity
    extends ObjetoTraza
{

    protected int actualizadorCiudad;
    protected DepartamentoEntity ciudadDepartamento;
    protected int codigoCiudad;
    protected int creadorCiudad;
    protected String estadoCiudad;
    protected int idCiudad;
    protected String nombreCiudad;

    /**
     * Obtiene el valor de la propiedad actualizadorCiudad.
     * 
     */
    public int getActualizadorCiudad() {
        return actualizadorCiudad;
    }

    /**
     * Define el valor de la propiedad actualizadorCiudad.
     * 
     */
    public void setActualizadorCiudad(int value) {
        this.actualizadorCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link DepartamentoEntity }
     *     
     */
    public DepartamentoEntity getCiudadDepartamento() {
        return ciudadDepartamento;
    }

    /**
     * Define el valor de la propiedad ciudadDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartamentoEntity }
     *     
     */
    public void setCiudadDepartamento(DepartamentoEntity value) {
        this.ciudadDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCiudad.
     * 
     */
    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    /**
     * Define el valor de la propiedad codigoCiudad.
     * 
     */
    public void setCodigoCiudad(int value) {
        this.codigoCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorCiudad.
     * 
     */
    public int getCreadorCiudad() {
        return creadorCiudad;
    }

    /**
     * Define el valor de la propiedad creadorCiudad.
     * 
     */
    public void setCreadorCiudad(int value) {
        this.creadorCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCiudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCiudad() {
        return estadoCiudad;
    }

    /**
     * Define el valor de la propiedad estadoCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCiudad(String value) {
        this.estadoCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad idCiudad.
     * 
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * Define el valor de la propiedad idCiudad.
     * 
     */
    public void setIdCiudad(int value) {
        this.idCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCiudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Define el valor de la propiedad nombreCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCiudad(String value) {
        this.nombreCiudad = value;
    }

}
