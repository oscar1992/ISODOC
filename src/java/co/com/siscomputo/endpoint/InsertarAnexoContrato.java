
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InsertarAnexoContrato complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarAnexoContrato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objAnexo" type="{http://endpoint.siscomputo.com.co/}anexoContratoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarAnexoContrato", propOrder = {
    "objAnexo"
})
public class InsertarAnexoContrato {

    protected AnexoContratoEntity objAnexo;

    /**
     * Obtiene el valor de la propiedad objAnexo.
     * 
     * @return
     *     possible object is
     *     {@link AnexoContratoEntity }
     *     
     */
    public AnexoContratoEntity getObjAnexo() {
        return objAnexo;
    }

    /**
     * Define el valor de la propiedad objAnexo.
     * 
     * @param value
     *     allowed object is
     *     {@link AnexoContratoEntity }
     *     
     */
    public void setObjAnexo(AnexoContratoEntity value) {
        this.objAnexo = value;
    }

}
