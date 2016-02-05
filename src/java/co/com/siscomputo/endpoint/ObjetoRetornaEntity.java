
package co.com.siscomputo.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para objetoRetornaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="objetoRetornaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="retorna" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetoRetornaEntity", propOrder = {
    "retorna"
})
@XmlSeeAlso({
    TipoTributarioEntity.class,
    EstadoProveedorEntity.class,
    LineaEntity.class,
    TipoDocumentoEntity.class,
    TipoProveedorEntity.class
})
public class ObjetoRetornaEntity
    extends ObjetoTraza
{

    @XmlElement(nillable = true)
    protected List<Object> retorna;

    /**
     * Gets the value of the retorna property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retorna property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetorna().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRetorna() {
        if (retorna == null) {
            retorna = new ArrayList<Object>();
        }
        return this.retorna;
    }

}
