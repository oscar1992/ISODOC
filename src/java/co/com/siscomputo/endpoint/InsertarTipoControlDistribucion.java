
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarTipoControlDistribucion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarTipoControlDistribucion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objeto" type="{http://endpoint.siscomputo.com.co/}tipoControlDistribucionEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarTipoControlDistribucion", propOrder = {
    "objeto"
})
public class InsertarTipoControlDistribucion {

    protected TipoControlDistribucionEntity objeto;

    /**
     * Obtiene el valor de la propiedad objeto.
     * 
     * @return
     *     possible object is
     *     {@link TipoControlDistribucionEntity }
     *     
     */
    public TipoControlDistribucionEntity getObjeto() {
        return objeto;
    }

    /**
     * Define el valor de la propiedad objeto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoControlDistribucionEntity }
     *     
     */
    public void setObjeto(TipoControlDistribucionEntity value) {
        this.objeto = value;
    }

}
