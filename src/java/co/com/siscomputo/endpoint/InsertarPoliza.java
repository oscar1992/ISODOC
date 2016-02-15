
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarPoliza complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarPoliza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolizaEntity" type="{http://endpoint.siscomputo.com.co/}polizasEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarPoliza", propOrder = {
    "polizaEntity"
})
public class InsertarPoliza {

    @XmlElement(name = "PolizaEntity")
    protected PolizasEntity polizaEntity;

    /**
     * Obtiene el valor de la propiedad polizaEntity.
     * 
     * @return
     *     possible object is
     *     {@link PolizasEntity }
     *     
     */
    public PolizasEntity getPolizaEntity() {
        return polizaEntity;
    }

    /**
     * Define el valor de la propiedad polizaEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link PolizasEntity }
     *     
     */
    public void setPolizaEntity(PolizasEntity value) {
        this.polizaEntity = value;
    }

}
