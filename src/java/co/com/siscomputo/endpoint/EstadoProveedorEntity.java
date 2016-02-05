
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoProveedorEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estadoProveedorEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoEstadoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idEstadoProveedor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoEstadoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoProveedorEntity", propOrder = {
    "estadoEstadoProveedor",
    "idEstadoProveedor",
    "tipoEstadoProveedor"
})
public class EstadoProveedorEntity
    extends ObjetoRetornaEntity
{

    protected String estadoEstadoProveedor;
    protected int idEstadoProveedor;
    protected String tipoEstadoProveedor;

    /**
     * Obtiene el valor de la propiedad estadoEstadoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoEstadoProveedor() {
        return estadoEstadoProveedor;
    }

    /**
     * Define el valor de la propiedad estadoEstadoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoEstadoProveedor(String value) {
        this.estadoEstadoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstadoProveedor.
     * 
     */
    public int getIdEstadoProveedor() {
        return idEstadoProveedor;
    }

    /**
     * Define el valor de la propiedad idEstadoProveedor.
     * 
     */
    public void setIdEstadoProveedor(int value) {
        this.idEstadoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoEstadoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEstadoProveedor() {
        return tipoEstadoProveedor;
    }

    /**
     * Define el valor de la propiedad tipoEstadoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEstadoProveedor(String value) {
        this.tipoEstadoProveedor = value;
    }

}
