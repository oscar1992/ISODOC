
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InsertarTipoEvaluacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarTipoEvaluacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoEvaluacion" type="{http://endpoint.siscomputo.com.co/}tipoEvaluacionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarTipoEvaluacion", propOrder = {
    "tipoEvaluacion"
})
public class InsertarTipoEvaluacion {

    @XmlElement(name = "TipoEvaluacion")
    protected TipoEvaluacionEntity tipoEvaluacion;

    /**
     * Obtiene el valor de la propiedad tipoEvaluacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public TipoEvaluacionEntity getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    /**
     * Define el valor de la propiedad tipoEvaluacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public void setTipoEvaluacion(TipoEvaluacionEntity value) {
        this.tipoEvaluacion = value;
    }

}
