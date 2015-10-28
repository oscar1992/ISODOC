
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paisEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="paisEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorPais" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codPais" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorPais" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPais" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombrePais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paisEntity", propOrder = {
    "actualizadorPais",
    "codPais",
    "creadorPais",
    "estadoPais",
    "idPais",
    "nombrePais"
})
public class PaisEntity
    extends ObjetoTraza
{

    protected int actualizadorPais;
    protected int codPais;
    protected int creadorPais;
    protected String estadoPais;
    protected int idPais;
    protected String nombrePais;

    /**
     * Obtiene el valor de la propiedad actualizadorPais.
     * 
     */
    public int getActualizadorPais() {
        return actualizadorPais;
    }

    /**
     * Define el valor de la propiedad actualizadorPais.
     * 
     */
    public void setActualizadorPais(int value) {
        this.actualizadorPais = value;
    }

    /**
     * Obtiene el valor de la propiedad codPais.
     * 
     */
    public int getCodPais() {
        return codPais;
    }

    /**
     * Define el valor de la propiedad codPais.
     * 
     */
    public void setCodPais(int value) {
        this.codPais = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorPais.
     * 
     */
    public int getCreadorPais() {
        return creadorPais;
    }

    /**
     * Define el valor de la propiedad creadorPais.
     * 
     */
    public void setCreadorPais(int value) {
        this.creadorPais = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoPais() {
        return estadoPais;
    }

    /**
     * Define el valor de la propiedad estadoPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoPais(String value) {
        this.estadoPais = value;
    }

    /**
     * Obtiene el valor de la propiedad idPais.
     * 
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * Define el valor de la propiedad idPais.
     * 
     */
    public void setIdPais(int value) {
        this.idPais = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * Define el valor de la propiedad nombrePais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePais(String value) {
        this.nombrePais = value;
    }

}
