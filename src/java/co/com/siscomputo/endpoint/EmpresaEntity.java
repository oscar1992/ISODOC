
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para empresaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="empresaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigoEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoEmpresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreEmpresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empresaEntity", propOrder = {
    "actualizadorEmpresa",
    "codigoEmpresa",
    "creadorEmpresa",
    "estadoEmpresa",
    "idEmpresa",
    "nombreEmpresa"
})
public class EmpresaEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorEmpresa;
    protected int codigoEmpresa;
    protected int creadorEmpresa;
    protected String estadoEmpresa;
    protected int idEmpresa;
    protected String nombreEmpresa;

    /**
     * Obtiene el valor de la propiedad actualizadorEmpresa.
     * 
     */
    public int getActualizadorEmpresa() {
        return actualizadorEmpresa;
    }

    /**
     * Define el valor de la propiedad actualizadorEmpresa.
     * 
     */
    public void setActualizadorEmpresa(int value) {
        this.actualizadorEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoEmpresa.
     * 
     */
    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * Define el valor de la propiedad codigoEmpresa.
     * 
     */
    public void setCodigoEmpresa(int value) {
        this.codigoEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorEmpresa.
     * 
     */
    public int getCreadorEmpresa() {
        return creadorEmpresa;
    }

    /**
     * Define el valor de la propiedad creadorEmpresa.
     * 
     */
    public void setCreadorEmpresa(int value) {
        this.creadorEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    /**
     * Define el valor de la propiedad estadoEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoEmpresa(String value) {
        this.estadoEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad idEmpresa.
     * 
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Define el valor de la propiedad idEmpresa.
     * 
     */
    public void setIdEmpresa(int value) {
        this.idEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Define el valor de la propiedad nombreEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEmpresa(String value) {
        this.nombreEmpresa = value;
    }

}
