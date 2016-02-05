
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoProveedorEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoProveedorEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoTipoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoProveedor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTipoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoProveedorEntity", propOrder = {
    "estadoTipoProveedor",
    "idTipoProveedor",
    "nombreTipoProveedor"
})
public class TipoProveedorEntity
    extends ObjetoRetornaEntity
{

    protected String estadoTipoProveedor;
    protected int idTipoProveedor;
    protected String nombreTipoProveedor;

    /**
     * Obtiene el valor de la propiedad estadoTipoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoProveedor() {
        return estadoTipoProveedor;
    }

    /**
     * Define el valor de la propiedad estadoTipoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoProveedor(String value) {
        this.estadoTipoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoProveedor.
     * 
     */
    public int getIdTipoProveedor() {
        return idTipoProveedor;
    }

    /**
     * Define el valor de la propiedad idTipoProveedor.
     * 
     */
    public void setIdTipoProveedor(int value) {
        this.idTipoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoProveedor() {
        return nombreTipoProveedor;
    }

    /**
     * Define el valor de la propiedad nombreTipoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoProveedor(String value) {
        this.nombreTipoProveedor = value;
    }

}
