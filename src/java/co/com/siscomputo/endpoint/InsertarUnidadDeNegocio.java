
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarUnidadDeNegocio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarUnidadDeNegocio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnidadNegocio" type="{http://endpoint.siscomputo.com.co/}unidadDeNegocioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarUnidadDeNegocio", propOrder = {
    "unidadNegocio"
})
public class InsertarUnidadDeNegocio {

    @XmlElement(name = "UnidadNegocio")
    protected UnidadDeNegocioEntity unidadNegocio;

    /**
     * Obtiene el valor de la propiedad unidadNegocio.
     * 
     * @return
     *     possible object is
     *     {@link UnidadDeNegocioEntity }
     *     
     */
    public UnidadDeNegocioEntity getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Define el valor de la propiedad unidadNegocio.
     * 
     * @param value
     *     allowed object is
     *     {@link UnidadDeNegocioEntity }
     *     
     */
    public void setUnidadNegocio(UnidadDeNegocioEntity value) {
        this.unidadNegocio = value;
    }

}
