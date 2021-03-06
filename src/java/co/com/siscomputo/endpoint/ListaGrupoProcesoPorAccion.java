
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaGrupoProcesoPorAccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaGrupoProcesoPorAccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaGrupoProcesoPorAccion", propOrder = {
    "idAccion",
    "idProceso"
})
public class ListaGrupoProcesoPorAccion {

    protected int idAccion;
    protected int idProceso;

    /**
     * Obtiene el valor de la propiedad idAccion.
     * 
     */
    public int getIdAccion() {
        return idAccion;
    }

    /**
     * Define el valor de la propiedad idAccion.
     * 
     */
    public void setIdAccion(int value) {
        this.idAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad idProceso.
     * 
     */
    public int getIdProceso() {
        return idProceso;
    }

    /**
     * Define el valor de la propiedad idProceso.
     * 
     */
    public void setIdProceso(int value) {
        this.idProceso = value;
    }

}
