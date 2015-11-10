
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarFestivo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarFestivo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="festivo" type="{http://endpoint.siscomputo.com.co/}festivosEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarFestivo", propOrder = {
    "festivo"
})
public class ActualizarFestivo {

    protected FestivosEntity festivo;

    /**
     * Obtiene el valor de la propiedad festivo.
     * 
     * @return
     *     possible object is
     *     {@link FestivosEntity }
     *     
     */
    public FestivosEntity getFestivo() {
        return festivo;
    }

    /**
     * Define el valor de la propiedad festivo.
     * 
     * @param value
     *     allowed object is
     *     {@link FestivosEntity }
     *     
     */
    public void setFestivo(FestivosEntity value) {
        this.festivo = value;
    }

}
