
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para plantillaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="plantillaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorPlantilla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorPlantilla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoPlantilla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPlantilla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombrePlantilla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutaPlantilla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plantillaEntity", propOrder = {
    "actualizadorPlantilla",
    "creadorPlantilla",
    "estadoPlantilla",
    "idPlantilla",
    "nombrePlantilla",
    "rutaPlantilla"
})
public class PlantillaEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorPlantilla;
    protected int creadorPlantilla;
    protected String estadoPlantilla;
    protected int idPlantilla;
    protected String nombrePlantilla;
    protected String rutaPlantilla;

    /**
     * Obtiene el valor de la propiedad actualizadorPlantilla.
     * 
     */
    public int getActualizadorPlantilla() {
        return actualizadorPlantilla;
    }

    /**
     * Define el valor de la propiedad actualizadorPlantilla.
     * 
     */
    public void setActualizadorPlantilla(int value) {
        this.actualizadorPlantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorPlantilla.
     * 
     */
    public int getCreadorPlantilla() {
        return creadorPlantilla;
    }

    /**
     * Define el valor de la propiedad creadorPlantilla.
     * 
     */
    public void setCreadorPlantilla(int value) {
        this.creadorPlantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoPlantilla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoPlantilla() {
        return estadoPlantilla;
    }

    /**
     * Define el valor de la propiedad estadoPlantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoPlantilla(String value) {
        this.estadoPlantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad idPlantilla.
     * 
     */
    public int getIdPlantilla() {
        return idPlantilla;
    }

    /**
     * Define el valor de la propiedad idPlantilla.
     * 
     */
    public void setIdPlantilla(int value) {
        this.idPlantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePlantilla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePlantilla() {
        return nombrePlantilla;
    }

    /**
     * Define el valor de la propiedad nombrePlantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePlantilla(String value) {
        this.nombrePlantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaPlantilla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaPlantilla() {
        return rutaPlantilla;
    }

    /**
     * Define el valor de la propiedad rutaPlantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaPlantilla(String value) {
        this.rutaPlantilla = value;
    }

}
