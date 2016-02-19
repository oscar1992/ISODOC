
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarAnexoEvalucion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarAnexoEvalucion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnexoEvaluacionesObj" type="{http://endpoint.siscomputo.com.co/}anexoEvalucionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarAnexoEvalucion", propOrder = {
    "anexoEvaluacionesObj"
})
public class ActualizarAnexoEvalucion {

    @XmlElement(name = "AnexoEvaluacionesObj")
    protected AnexoEvalucionEntity anexoEvaluacionesObj;

    /**
     * Obtiene el valor de la propiedad anexoEvaluacionesObj.
     * 
     * @return
     *     possible object is
     *     {@link AnexoEvalucionEntity }
     *     
     */
    public AnexoEvalucionEntity getAnexoEvaluacionesObj() {
        return anexoEvaluacionesObj;
    }

    /**
     * Define el valor de la propiedad anexoEvaluacionesObj.
     * 
     * @param value
     *     allowed object is
     *     {@link AnexoEvalucionEntity }
     *     
     */
    public void setAnexoEvaluacionesObj(AnexoEvalucionEntity value) {
        this.anexoEvaluacionesObj = value;
    }

}
