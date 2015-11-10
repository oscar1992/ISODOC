
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para festtivoPorId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="festtivoPorId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFestivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "festtivoPorId", propOrder = {
    "idFestivo"
})
public class FesttivoPorId {

    protected int idFestivo;

    /**
     * Obtiene el valor de la propiedad idFestivo.
     * 
     */
    public int getIdFestivo() {
        return idFestivo;
    }

    /**
     * Define el valor de la propiedad idFestivo.
     * 
     */
    public void setIdFestivo(int value) {
        this.idFestivo = value;
    }

}
