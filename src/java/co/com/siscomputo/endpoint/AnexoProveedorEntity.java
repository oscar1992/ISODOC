
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anexoProveedorEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="anexoProveedorEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idAnexoProveedor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="proveedorAnexoProveedor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rutaAnexoProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anexoProveedorEntity", propOrder = {
    "idAnexoProveedor",
    "proveedorAnexoProveedor",
    "rutaAnexoProveedor"
})
public class AnexoProveedorEntity
    extends ObjetoRetornaEntity
{

    protected int idAnexoProveedor;
    protected int proveedorAnexoProveedor;
    protected String rutaAnexoProveedor;

    /**
     * Obtiene el valor de la propiedad idAnexoProveedor.
     * 
     */
    public int getIdAnexoProveedor() {
        return idAnexoProveedor;
    }

    /**
     * Define el valor de la propiedad idAnexoProveedor.
     * 
     */
    public void setIdAnexoProveedor(int value) {
        this.idAnexoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedorAnexoProveedor.
     * 
     */
    public int getProveedorAnexoProveedor() {
        return proveedorAnexoProveedor;
    }

    /**
     * Define el valor de la propiedad proveedorAnexoProveedor.
     * 
     */
    public void setProveedorAnexoProveedor(int value) {
        this.proveedorAnexoProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaAnexoProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaAnexoProveedor() {
        return rutaAnexoProveedor;
    }

    /**
     * Define el valor de la propiedad rutaAnexoProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaAnexoProveedor(String value) {
        this.rutaAnexoProveedor = value;
    }

}
