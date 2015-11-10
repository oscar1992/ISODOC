
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para festivosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="festivosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="fechaFestivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idFEstivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreFestivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "festivosEntity", propOrder = {
    "fechaFestivo",
    "idFEstivo",
    "nombreFestivo"
})
public class FestivosEntity
    extends ObjetoTraza
{

    protected String fechaFestivo;
    protected int idFEstivo;
    protected String nombreFestivo;

    /**
     * Obtiene el valor de la propiedad fechaFestivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFestivo() {
        return fechaFestivo;
    }

    /**
     * Define el valor de la propiedad fechaFestivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFestivo(String value) {
        this.fechaFestivo = value;
    }

    /**
     * Obtiene el valor de la propiedad idFEstivo.
     * 
     */
    public int getIdFEstivo() {
        return idFEstivo;
    }

    /**
     * Define el valor de la propiedad idFEstivo.
     * 
     */
    public void setIdFEstivo(int value) {
        this.idFEstivo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreFestivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFestivo() {
        return nombreFestivo;
    }

    /**
     * Define el valor de la propiedad nombreFestivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFestivo(String value) {
        this.nombreFestivo = value;
    }

}
