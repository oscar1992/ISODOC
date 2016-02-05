
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoTributarioEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoTributarioEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="estadoTipoTributario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoTributario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTipoTributario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoTributarioEntity", propOrder = {
    "estadoTipoTributario",
    "idTipoTributario",
    "nombreTipoTributario"
})
public class TipoTributarioEntity
    extends ObjetoRetornaEntity
{

    protected String estadoTipoTributario;
    protected int idTipoTributario;
    protected String nombreTipoTributario;

    /**
     * Obtiene el valor de la propiedad estadoTipoTributario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTipoTributario() {
        return estadoTipoTributario;
    }

    /**
     * Define el valor de la propiedad estadoTipoTributario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTipoTributario(String value) {
        this.estadoTipoTributario = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoTributario.
     * 
     */
    public int getIdTipoTributario() {
        return idTipoTributario;
    }

    /**
     * Define el valor de la propiedad idTipoTributario.
     * 
     */
    public void setIdTipoTributario(int value) {
        this.idTipoTributario = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTipoTributario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipoTributario() {
        return nombreTipoTributario;
    }

    /**
     * Define el valor de la propiedad nombreTipoTributario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipoTributario(String value) {
        this.nombreTipoTributario = value;
    }

}
