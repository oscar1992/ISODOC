
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresaSubProceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresaSubProceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subproceso" type="{http://endpoint.siscomputo.com.co/}subprocesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresaSubProceso", propOrder = {
    "subproceso"
})
public class IngresaSubProceso {

    protected SubprocesoEntity subproceso;

    /**
     * Obtiene el valor de la propiedad subproceso.
     * 
     * @return
     *     possible object is
     *     {@link SubprocesoEntity }
     *     
     */
    public SubprocesoEntity getSubproceso() {
        return subproceso;
    }

    /**
     * Define el valor de la propiedad subproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link SubprocesoEntity }
     *     
     */
    public void setSubproceso(SubprocesoEntity value) {
        this.subproceso = value;
    }

}
