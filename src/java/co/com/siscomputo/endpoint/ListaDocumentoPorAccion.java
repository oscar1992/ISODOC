
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaDocumentoPorAccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaDocumentoPorAccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccionE" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaDocumentoPorAccion", propOrder = {
    "accionE"
})
public class ListaDocumentoPorAccion {

    @XmlElement(name = "AccionE")
    protected AccionEntity accionE;

    /**
     * Obtiene el valor de la propiedad accionE.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getAccionE() {
        return accionE;
    }

    /**
     * Define el valor de la propiedad accionE.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setAccionE(AccionEntity value) {
        this.accionE = value;
    }

}
