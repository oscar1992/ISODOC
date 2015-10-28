
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingresaSedeEmpresa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingresaSedeEmpresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sedee" type="{http://endpoint.siscomputo.com.co/}sedeEmpresaEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingresaSedeEmpresa", propOrder = {
    "sedee"
})
public class IngresaSedeEmpresa {

    protected SedeEmpresaEntity sedee;

    /**
     * Obtiene el valor de la propiedad sedee.
     * 
     * @return
     *     possible object is
     *     {@link SedeEmpresaEntity }
     *     
     */
    public SedeEmpresaEntity getSedee() {
        return sedee;
    }

    /**
     * Define el valor de la propiedad sedee.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeEmpresaEntity }
     *     
     */
    public void setSedee(SedeEmpresaEntity value) {
        this.sedee = value;
    }

}
