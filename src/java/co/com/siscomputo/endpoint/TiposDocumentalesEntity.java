
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tiposDocumentalesEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tiposDocumentalesEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizaTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consecutivoTipoDocuemntal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorTpoDocumental" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoTipoDocuemtal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genracionTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inicialesTipoDocuemntal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tiposDocumentalesEntity", propOrder = {
    "actualizaTipoDocumental",
    "consecutivoTipoDocuemntal",
    "creadorTpoDocumental",
    "estadoTipoDocuemtal",
    "genracionTipoDocumental",
    "idTipoDocumental",
    "inicialesTipoDocuemntal",
    "nombreTipoDocumental"
})
public class TiposDocumentalesEntity
    extends ObjetoRetornaEntity
{

    protected int actualizaTipoDocumental;
    protected int consecutivoTipoDocuemntal;
    protected int creadorTpoDocumental;
    protected String estadoTipoDocuemtal;
    protected String genracionTipoDocumental;
    protected int idTipoDocumental;
    protected String inicialesTipoDocuemntal;
    protected String nombreTipoDocumental;

    /**
     * Obtiene el valor de la propiedad actualizaTipoDocumental.
     * 
     */
    public int getActualizaTipoDocumental() {
        return actualizaTipoDocumental;
    }

    /**
     * Define el valor de la propiedad actualizaTipoDocumental.
     * 
     */
    public void setActualizaTipoDocumental(int value) {
        this.actualizaTipoDocumental = value;
    }

    /**
     * Obtiene el valor de la propiedad consecutivoTipoDocuemntal.
     * 
     */
    public int getConsecutivoTipoDocuemntal() {
        return consecutivoTipoDocuemntal;
    }

    /**
     * Define el valor de la propiedad consecutivoTipoDocuemntal.
     * 
     */
    public void setConsecutivoTipoDocuemntal(int value) {
        this.consecutivoTipoDocuemntal = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorTpoDocumental.
     * 
     */
    public int getCreadorTpoDocumental() {
        return creadorTpoDocumental;
    }

    /**
     * Define el valor de la propiedad creadorTpoDocumental.
     * 
     */
    public void setCreadorTpoDocumental(int value) {
        this.creadorTpoDocumental = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoTipoDocuemtal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoDocuemtal() {
        return estadoTipoDocuemtal;
    }

    /**
     * Define el valor de la propiedad estadoTipoDocuemtal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoDocuemtal(String value) {
        this.estadoTipoDocuemtal = value;
    }

    /**
     * Obtiene el valor de la propiedad genracionTipoDocumental.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenracionTipoDocumental() {
        return genracionTipoDocumental;
    }

    /**
     * Define el valor de la propiedad genracionTipoDocumental.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenracionTipoDocumental(String value) {
        this.genracionTipoDocumental = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoDocumental.
     * 
     */
    public int getIdTipoDocumental() {
        return idTipoDocumental;
    }

    /**
     * Define el valor de la propiedad idTipoDocumental.
     * 
     */
    public void setIdTipoDocumental(int value) {
        this.idTipoDocumental = value;
    }

    /**
     * Obtiene el valor de la propiedad inicialesTipoDocuemntal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicialesTipoDocuemntal() {
        return inicialesTipoDocuemntal;
    }

    /**
     * Define el valor de la propiedad inicialesTipoDocuemntal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicialesTipoDocuemntal(String value) {
        this.inicialesTipoDocuemntal = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoDocumental.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoDocumental() {
        return nombreTipoDocumental;
    }

    /**
     * Define el valor de la propiedad nombreTipoDocumental.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoDocumental(String value) {
        this.nombreTipoDocumental = value;
    }

}
