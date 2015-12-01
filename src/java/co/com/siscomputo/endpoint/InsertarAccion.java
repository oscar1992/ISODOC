
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarAccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarAccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objeto" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarAccion", propOrder = {
    "objeto"
})
public class InsertarAccion {

    protected AccionEntity objeto;

    /**
     * Obtiene el valor de la propiedad objeto.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getObjeto() {
        return objeto;
    }

    /**
     * Define el valor de la propiedad objeto.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setObjeto(AccionEntity value) {
        this.objeto = value;
    }

}
