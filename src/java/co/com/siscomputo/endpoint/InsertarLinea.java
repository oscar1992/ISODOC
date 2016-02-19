
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarLinea complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarLinea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InsertarLineaObjeto" type="{http://endpoint.siscomputo.com.co/}lineaEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarLinea", propOrder = {
    "insertarLineaObjeto"
})
public class InsertarLinea {

    @XmlElement(name = "InsertarLineaObjeto")
    protected LineaEntity insertarLineaObjeto;

    /**
     * Obtiene el valor de la propiedad insertarLineaObjeto.
     * 
     * @return
     *     possible object is
     *     {@link LineaEntity }
     *     
     */
    public LineaEntity getInsertarLineaObjeto() {
        return insertarLineaObjeto;
    }

    /**
     * Define el valor de la propiedad insertarLineaObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link LineaEntity }
     *     
     */
    public void setInsertarLineaObjeto(LineaEntity value) {
        this.insertarLineaObjeto = value;
    }

}
