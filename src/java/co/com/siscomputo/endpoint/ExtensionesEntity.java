
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para extensionesEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="extensionesEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idExtensiones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoExtensiones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extensionesEntity", propOrder = {
    "idExtensiones",
    "tipoExtensiones"
})
public class ExtensionesEntity
    extends ObjetoRetornaEntity
{

    protected int idExtensiones;
    protected String tipoExtensiones;

    /**
     * Obtiene el valor de la propiedad idExtensiones.
     * 
     */
    public int getIdExtensiones() {
        return idExtensiones;
    }

    /**
     * Define el valor de la propiedad idExtensiones.
     * 
     */
    public void setIdExtensiones(int value) {
        this.idExtensiones = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoExtensiones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoExtensiones() {
        return tipoExtensiones;
    }

    /**
     * Define el valor de la propiedad tipoExtensiones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoExtensiones(String value) {
        this.tipoExtensiones = value;
    }

}
