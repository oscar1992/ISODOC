
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InsertarTemaEvaluacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarTemaEvaluacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TemaEvaluacion" type="{http://endpoint.siscomputo.com.co/}temaEvaluacionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarTemaEvaluacion", propOrder = {
    "temaEvaluacion"
})
public class InsertarTemaEvaluacion {

    @XmlElement(name = "TemaEvaluacion")
    protected TemaEvaluacionEntity temaEvaluacion;

    /**
     * Obtiene el valor de la propiedad temaEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link TemaEvaluacionEntity }
     *     
     */
    public TemaEvaluacionEntity getTemaEvaluacion() {
        return temaEvaluacion;
    }

    /**
     * Define el valor de la propiedad temaEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TemaEvaluacionEntity }
     *     
     */
    public void setTemaEvaluacion(TemaEvaluacionEntity value) {
        this.temaEvaluacion = value;
    }

}
