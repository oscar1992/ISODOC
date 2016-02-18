
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para temaEvaluacionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="temaEvaluacionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idTemaEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxRespuestaEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombreTemaEvaluacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="porcentajeEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="temaEvaluacion" type="{http://endpoint.siscomputo.com.co/}tipoEvaluacionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temaEvaluacionEntity", propOrder = {
    "idTemaEvaluacion",
    "maxRespuestaEvaluacion",
    "nombreTemaEvaluacion",
    "porcentajeEvaluacion",
    "temaEvaluacion"
})
public class TemaEvaluacionEntity
    extends ObjetoRetornaEntity
{

    protected Integer idTemaEvaluacion;
    protected Integer maxRespuestaEvaluacion;
    protected String nombreTemaEvaluacion;
    protected Integer porcentajeEvaluacion;
    protected TipoEvaluacionEntity temaEvaluacion;

    /**
     * Obtiene el valor de la propiedad idTemaEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTemaEvaluacion() {
        return idTemaEvaluacion;
    }

    /**
     * Define el valor de la propiedad idTemaEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTemaEvaluacion(Integer value) {
        this.idTemaEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad maxRespuestaEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRespuestaEvaluacion() {
        return maxRespuestaEvaluacion;
    }

    /**
     * Define el valor de la propiedad maxRespuestaEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRespuestaEvaluacion(Integer value) {
        this.maxRespuestaEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTemaEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTemaEvaluacion() {
        return nombreTemaEvaluacion;
    }

    /**
     * Define el valor de la propiedad nombreTemaEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTemaEvaluacion(String value) {
        this.nombreTemaEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPorcentajeEvaluacion() {
        return porcentajeEvaluacion;
    }

    /**
     * Define el valor de la propiedad porcentajeEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPorcentajeEvaluacion(Integer value) {
        this.porcentajeEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad temaEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public TipoEvaluacionEntity getTemaEvaluacion() {
        return temaEvaluacion;
    }

    /**
     * Define el valor de la propiedad temaEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public void setTemaEvaluacion(TipoEvaluacionEntity value) {
        this.temaEvaluacion = value;
    }

}
