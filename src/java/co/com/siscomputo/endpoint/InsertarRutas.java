
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarRutas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarRutas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rutas" type="{http://endpoint.siscomputo.com.co/}rutasEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarRutas", propOrder = {
    "rutas"
})
public class InsertarRutas {

    protected RutasEntity rutas;

    /**
     * Obtiene el valor de la propiedad rutas.
     * 
     * @return
     *     possible object is
     *     {@link RutasEntity }
     *     
     */
    public RutasEntity getRutas() {
        return rutas;
    }

    /**
     * Define el valor de la propiedad rutas.
     * 
     * @param value
     *     allowed object is
     *     {@link RutasEntity }
     *     
     */
    public void setRutas(RutasEntity value) {
        this.rutas = value;
    }

}
