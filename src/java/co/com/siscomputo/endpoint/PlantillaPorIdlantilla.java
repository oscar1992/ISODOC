
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para plantillaPorIdlantilla complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="plantillaPorIdlantilla">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPlantilla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plantillaPorIdlantilla", propOrder = {
    "idPlantilla"
})
public class PlantillaPorIdlantilla {

    protected int idPlantilla;

    /**
     * Obtiene el valor de la propiedad idPlantilla.
     * 
     */
    public int getIdPlantilla() {
        return idPlantilla;
    }

    /**
     * Define el valor de la propiedad idPlantilla.
     * 
     */
    public void setIdPlantilla(int value) {
        this.idPlantilla = value;
    }

}
