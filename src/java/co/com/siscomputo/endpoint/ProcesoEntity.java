
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para procesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="procesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizaProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="asociadoProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creaProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nivelProceso" type="{http://endpoint.siscomputo.com.co/}nivelEntity" minOccurs="0"/>
 *         &lt;element name="nombreProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procesoEntity", propOrder = {
    "actualizaProceso",
    "asociadoProceso",
    "creaProceso",
    "estadoProceso",
    "idProceso",
    "nivelProceso",
    "nombreProceso"
})
public class ProcesoEntity
    extends ObjetoRetornaEntity
{

    protected int actualizaProceso;
    protected int asociadoProceso;
    protected int creaProceso;
    protected String estadoProceso;
    protected int idProceso;
    protected NivelEntity nivelProceso;
    protected String nombreProceso;

    /**
     * Obtiene el valor de la propiedad actualizaProceso.
     * 
     */
    public int getActualizaProceso() {
        return actualizaProceso;
    }

    /**
     * Define el valor de la propiedad actualizaProceso.
     * 
     */
    public void setActualizaProceso(int value) {
        this.actualizaProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad asociadoProceso.
     * 
     */
    public int getAsociadoProceso() {
        return asociadoProceso;
    }

    /**
     * Define el valor de la propiedad asociadoProceso.
     * 
     */
    public void setAsociadoProceso(int value) {
        this.asociadoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad creaProceso.
     * 
     */
    public int getCreaProceso() {
        return creaProceso;
    }

    /**
     * Define el valor de la propiedad creaProceso.
     * 
     */
    public void setCreaProceso(int value) {
        this.creaProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoProceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoProceso() {
        return estadoProceso;
    }

    /**
     * Define el valor de la propiedad estadoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoProceso(String value) {
        this.estadoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idProceso.
     * 
     */
    public int getIdProceso() {
        return idProceso;
    }

    /**
     * Define el valor de la propiedad idProceso.
     * 
     */
    public void setIdProceso(int value) {
        this.idProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad nivelProceso.
     * 
     * @return
     *     possible object is
     *     {@link NivelEntity }
     *     
     */
    public NivelEntity getNivelProceso() {
        return nivelProceso;
    }

    /**
     * Define el valor de la propiedad nivelProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link NivelEntity }
     *     
     */
    public void setNivelProceso(NivelEntity value) {
        this.nivelProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     * Define el valor de la propiedad nombreProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProceso(String value) {
        this.nombreProceso = value;
    }

}
