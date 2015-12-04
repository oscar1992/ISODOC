
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaUsuariosPorAccionMacroproceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaUsuariosPorAccionMacroproceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idMacro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaUsuariosPorAccionMacroproceso", propOrder = {
    "idAccion",
    "idMacro"
})
public class ListaUsuariosPorAccionMacroproceso {

    protected int idAccion;
    protected int idMacro;

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
     * Obtiene el valor de la propiedad idMacro.
     * 
     */
    public int getIdMacro() {
        return idMacro;
    }

    /**
     * Define el valor de la propiedad idMacro.
     * 
     */
    public void setIdMacro(int value) {
        this.idMacro = value;
    }

}
