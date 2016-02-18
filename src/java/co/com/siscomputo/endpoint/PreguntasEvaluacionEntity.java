
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para preguntasEvaluacionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="preguntasEvaluacionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="descripcionDetallada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idEvaluacionPregunta" type="{http://endpoint.siscomputo.com.co/}evaluacionesEntity" minOccurs="0"/>
 *         &lt;element name="idPregunta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTemaPregunta" type="{http://endpoint.siscomputo.com.co/}temaEvaluacionEntity" minOccurs="0"/>
 *         &lt;element name="pesoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pregunta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preguntasEvaluacionEntity", propOrder = {
    "descripcionDetallada",
    "idEvaluacionPregunta",
    "idPregunta",
    "idTemaPregunta",
    "pesoItem",
    "pregunta"
})
public class PreguntasEvaluacionEntity
    extends ObjetoRetornaEntity
{

    protected String descripcionDetallada;
    protected EvaluacionesEntity idEvaluacionPregunta;
    protected Integer idPregunta;
    protected TemaEvaluacionEntity idTemaPregunta;
    protected String pesoItem;
    protected String pregunta;

    /**
     * Obtiene el valor de la propiedad descripcionDetallada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    /**
     * Define el valor de la propiedad descripcionDetallada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionDetallada(String value) {
        this.descripcionDetallada = value;
    }

    /**
     * Obtiene el valor de la propiedad idEvaluacionPregunta.
     * 
     * @return
     *     possible object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public EvaluacionesEntity getIdEvaluacionPregunta() {
        return idEvaluacionPregunta;
    }

    /**
     * Define el valor de la propiedad idEvaluacionPregunta.
     * 
     * @param value
     *     allowed object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public void setIdEvaluacionPregunta(EvaluacionesEntity value) {
        this.idEvaluacionPregunta = value;
    }

    /**
     * Obtiene el valor de la propiedad idPregunta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPregunta() {
        return idPregunta;
    }

    /**
     * Define el valor de la propiedad idPregunta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPregunta(Integer value) {
        this.idPregunta = value;
    }

    /**
     * Obtiene el valor de la propiedad idTemaPregunta.
     * 
     * @return
     *     possible object is
     *     {@link TemaEvaluacionEntity }
     *     
     */
    public TemaEvaluacionEntity getIdTemaPregunta() {
        return idTemaPregunta;
    }

    /**
     * Define el valor de la propiedad idTemaPregunta.
     * 
     * @param value
     *     allowed object is
     *     {@link TemaEvaluacionEntity }
     *     
     */
    public void setIdTemaPregunta(TemaEvaluacionEntity value) {
        this.idTemaPregunta = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoItem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPesoItem() {
        return pesoItem;
    }

    /**
     * Define el valor de la propiedad pesoItem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPesoItem(String value) {
        this.pesoItem = value;
    }

    /**
     * Obtiene el valor de la propiedad pregunta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Define el valor de la propiedad pregunta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPregunta(String value) {
        this.pregunta = value;
    }

}
