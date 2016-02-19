
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarEvaluaciones complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarEvaluaciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EvaluacionesObj" type="{http://endpoint.siscomputo.com.co/}evaluacionesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarEvaluaciones", propOrder = {
    "evaluacionesObj"
})
public class InsertarEvaluaciones {

    @XmlElement(name = "EvaluacionesObj")
    protected EvaluacionesEntity evaluacionesObj;

    /**
     * Obtiene el valor de la propiedad evaluacionesObj.
     * 
     * @return
     *     possible object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public EvaluacionesEntity getEvaluacionesObj() {
        return evaluacionesObj;
    }

    /**
     * Define el valor de la propiedad evaluacionesObj.
     * 
     * @param value
     *     allowed object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public void setEvaluacionesObj(EvaluacionesEntity value) {
        this.evaluacionesObj = value;
    }

}
