
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para accionPorId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="accionPorId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accionPorId", propOrder = {
    "idAccion"
})
public class AccionPorId {

    protected int idAccion;

    /**
     * Obtiene el valor de la propiedad idAccion.
     * 
     */
    public int getIdAccion() {
        return idAccion;
    }

    /**
     * Define el valor de la propiedad idAccion.
     * 
     */
    public void setIdAccion(int value) {
        this.idAccion = value;
    }

}
