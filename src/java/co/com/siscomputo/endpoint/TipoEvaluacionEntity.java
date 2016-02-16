
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoEvaluacionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoEvaluacionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="evaluacionMetaInferior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="evaluacionMetaMedia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="evaluacionMetaSuperior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombreTipoEvaluacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periocidadEvaluacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rangoAltoEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rangoBajoEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rangoMedioEvaluacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoEvaluacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoEvaluacionEntity", propOrder = {
    "evaluacionMetaInferior",
    "evaluacionMetaMedia",
    "evaluacionMetaSuperior",
    "idTipoEvaluacion",
    "nombreTipoEvaluacion",
    "periocidadEvaluacion",
    "rangoAltoEvaluacion",
    "rangoBajoEvaluacion",
    "rangoMedioEvaluacion",
    "tipoEvaluacion"
})
public class TipoEvaluacionEntity
    extends ObjetoRetornaEntity
{

    protected String evaluacionMetaInferior;
    protected String evaluacionMetaMedia;
    protected String evaluacionMetaSuperior;
    protected Integer idTipoEvaluacion;
    protected String nombreTipoEvaluacion;
    protected String periocidadEvaluacion;
    protected Integer rangoAltoEvaluacion;
    protected Integer rangoBajoEvaluacion;
    protected Integer rangoMedioEvaluacion;
    protected String tipoEvaluacion;

    /**
     * Obtiene el valor de la propiedad evaluacionMetaInferior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluacionMetaInferior() {
        return evaluacionMetaInferior;
    }

    /**
     * Define el valor de la propiedad evaluacionMetaInferior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluacionMetaInferior(String value) {
        this.evaluacionMetaInferior = value;
    }

    /**
     * Obtiene el valor de la propiedad evaluacionMetaMedia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluacionMetaMedia() {
        return evaluacionMetaMedia;
    }

    /**
     * Define el valor de la propiedad evaluacionMetaMedia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluacionMetaMedia(String value) {
        this.evaluacionMetaMedia = value;
    }

    /**
     * Obtiene el valor de la propiedad evaluacionMetaSuperior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluacionMetaSuperior() {
        return evaluacionMetaSuperior;
    }

    /**
     * Define el valor de la propiedad evaluacionMetaSuperior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluacionMetaSuperior(String value) {
        this.evaluacionMetaSuperior = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoEvaluacion() {
        return idTipoEvaluacion;
    }

    /**
     * Define el valor de la propiedad idTipoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoEvaluacion(Integer value) {
        this.idTipoEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoEvaluacion() {
        return nombreTipoEvaluacion;
    }

    /**
     * Define el valor de la propiedad nombreTipoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoEvaluacion(String value) {
        this.nombreTipoEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad periocidadEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriocidadEvaluacion() {
        return periocidadEvaluacion;
    }

    /**
     * Define el valor de la propiedad periocidadEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriocidadEvaluacion(String value) {
        this.periocidadEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad rangoAltoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRangoAltoEvaluacion() {
        return rangoAltoEvaluacion;
    }

    /**
     * Define el valor de la propiedad rangoAltoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRangoAltoEvaluacion(Integer value) {
        this.rangoAltoEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad rangoBajoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRangoBajoEvaluacion() {
        return rangoBajoEvaluacion;
    }

    /**
     * Define el valor de la propiedad rangoBajoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRangoBajoEvaluacion(Integer value) {
        this.rangoBajoEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad rangoMedioEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRangoMedioEvaluacion() {
        return rangoMedioEvaluacion;
    }

    /**
     * Define el valor de la propiedad rangoMedioEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRangoMedioEvaluacion(Integer value) {
        this.rangoMedioEvaluacion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    /**
     * Define el valor de la propiedad tipoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEvaluacion(String value) {
        this.tipoEvaluacion = value;
    }

}
