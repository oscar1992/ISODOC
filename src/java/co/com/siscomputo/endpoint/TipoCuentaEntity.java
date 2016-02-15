
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoCuentaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoCuentaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoTipoCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoCuenta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoTipoCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoCuentaEntity", propOrder = {
    "estadoTipoCuenta",
    "idTipoCuenta",
    "tipoTipoCuenta"
})
public class TipoCuentaEntity
    extends ObjetoRetornaEntity
{

    protected String estadoTipoCuenta;
    protected int idTipoCuenta;
    protected String tipoTipoCuenta;

    /**
     * Obtiene el valor de la propiedad estadoTipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoCuenta() {
        return estadoTipoCuenta;
    }

    /**
     * Define el valor de la propiedad estadoTipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoCuenta(String value) {
        this.estadoTipoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoCuenta.
     * 
     */
    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    /**
     * Define el valor de la propiedad idTipoCuenta.
     * 
     */
    public void setIdTipoCuenta(int value) {
        this.idTipoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTipoCuenta() {
        return tipoTipoCuenta;
    }

    /**
     * Define el valor de la propiedad tipoTipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTipoCuenta(String value) {
        this.tipoTipoCuenta = value;
    }

}
