
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ActualizarPreguntas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ActualizarPreguntas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PreguntasEvaluacion" type="{http://endpoint.siscomputo.com.co/}preguntasEvaluacionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualizarPreguntas", propOrder = {
    "preguntasEvaluacion"
})
public class ActualizarPreguntas {

    @XmlElement(name = "PreguntasEvaluacion")
    protected PreguntasEvaluacionEntity preguntasEvaluacion;

    /**
     * Obtiene el valor de la propiedad preguntasEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link PreguntasEvaluacionEntity }
     *     
     */
    public PreguntasEvaluacionEntity getPreguntasEvaluacion() {
        return preguntasEvaluacion;
    }

    /**
     * Define el valor de la propiedad preguntasEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link PreguntasEvaluacionEntity }
     *     
     */
    public void setPreguntasEvaluacion(PreguntasEvaluacionEntity value) {
        this.preguntasEvaluacion = value;
    }

}
