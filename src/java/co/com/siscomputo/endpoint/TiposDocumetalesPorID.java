
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tiposDocumetalesPorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tiposDocumetalesPorID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idipos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tiposDocumetalesPorID", propOrder = {
    "idipos"
})
public class TiposDocumetalesPorID {

    protected int idipos;

    /**
     * Obtiene el valor de la propiedad idipos.
     * 
     */
    public int getIdipos() {
        return idipos;
    }

    /**
     * Define el valor de la propiedad idipos.
     * 
     */
    public void setIdipos(int value) {
        this.idipos = value;
    }

}
