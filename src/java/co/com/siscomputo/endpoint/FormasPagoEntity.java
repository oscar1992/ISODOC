
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para formasPagoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="formasPagoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoFormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idFormasPagos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoFormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formasPagoEntity", propOrder = {
    "estadoFormaPago",
    "idFormasPagos",
    "tipoFormaPago"
})
public class FormasPagoEntity
    extends ObjetoRetornaEntity
{

    protected String estadoFormaPago;
    protected int idFormasPagos;
    protected String tipoFormaPago;

    /**
     * Obtiene el valor de la propiedad estadoFormaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoFormaPago() {
        return estadoFormaPago;
    }

    /**
     * Define el valor de la propiedad estadoFormaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoFormaPago(String value) {
        this.estadoFormaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad idFormasPagos.
     * 
     */
    public int getIdFormasPagos() {
        return idFormasPagos;
    }

    /**
     * Define el valor de la propiedad idFormasPagos.
     * 
     */
    public void setIdFormasPagos(int value) {
        this.idFormasPagos = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoFormaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFormaPago() {
        return tipoFormaPago;
    }

    /**
     * Define el valor de la propiedad tipoFormaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFormaPago(String value) {
        this.tipoFormaPago = value;
    }

}
