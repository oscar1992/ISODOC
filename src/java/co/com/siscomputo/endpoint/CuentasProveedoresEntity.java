
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cuentasProveedoresEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cuentasProveedoresEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoCuentasProveedores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCuentasProveedores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreCuentasProveedores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuentasProveedoresEntity", propOrder = {
    "estadoCuentasProveedores",
    "idCuentasProveedores",
    "nombreCuentasProveedores"
})
public class CuentasProveedoresEntity
    extends ObjetoRetornaEntity
{

    protected String estadoCuentasProveedores;
    protected int idCuentasProveedores;
    protected String nombreCuentasProveedores;

    /**
     * Obtiene el valor de la propiedad estadoCuentasProveedores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCuentasProveedores() {
        return estadoCuentasProveedores;
    }

    /**
     * Define el valor de la propiedad estadoCuentasProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCuentasProveedores(String value) {
        this.estadoCuentasProveedores = value;
    }

    /**
     * Obtiene el valor de la propiedad idCuentasProveedores.
     * 
     */
    public int getIdCuentasProveedores() {
        return idCuentasProveedores;
    }

    /**
     * Define el valor de la propiedad idCuentasProveedores.
     * 
     */
    public void setIdCuentasProveedores(int value) {
        this.idCuentasProveedores = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCuentasProveedores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCuentasProveedores() {
        return nombreCuentasProveedores;
    }

    /**
     * Define el valor de la propiedad nombreCuentasProveedores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCuentasProveedores(String value) {
        this.nombreCuentasProveedores = value;
    }

}
