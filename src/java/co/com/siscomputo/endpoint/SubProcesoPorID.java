
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para subProcesoPorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subProcesoPorID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subProcesoPorID", propOrder = {
    "subproceso"
})
public class SubProcesoPorID {

    protected int subproceso;

    /**
     * Obtiene el valor de la propiedad subproceso.
     * 
     */
    public int getSubproceso() {
        return subproceso;
    }

    /**
     * Define el valor de la propiedad subproceso.
     * 
     */
    public void setSubproceso(int value) {
        this.subproceso = value;
    }

}
