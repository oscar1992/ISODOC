
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para objetoLogin complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="objetoLogin">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="acceso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="traza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetoLogin", propOrder = {
    "acceso",
    "idUsuario",
    "traza"
})
public class ObjetoLogin
    extends ObjetoTraza
{

    protected boolean acceso;
    protected int idUsuario;
    protected String traza;

    /**
     * Obtiene el valor de la propiedad acceso.
     * 
     */
    public boolean isAcceso() {
        return acceso;
    }

    /**
     * Define el valor de la propiedad acceso.
     * 
     */
    public void setAcceso(boolean value) {
        this.acceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad traza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraza() {
        return traza;
    }

    /**
     * Define el valor de la propiedad traza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraza(String value) {
        this.traza = value;
    }

}
