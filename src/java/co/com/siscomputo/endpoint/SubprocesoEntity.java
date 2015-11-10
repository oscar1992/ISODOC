
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para subprocesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subprocesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoSubproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProcesos" type="{http://endpoint.siscomputo.com.co/}procesosEntity" minOccurs="0"/>
 *         &lt;element name="idSubproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreSubproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subprocesoEntity", propOrder = {
    "actualizadorProceso",
    "creadorProceso",
    "estadoSubproceso",
    "idProcesos",
    "idSubproceso",
    "nombreSubproceso"
})
public class SubprocesoEntity
    extends ObjetoTraza
{

    protected int actualizadorProceso;
    protected int creadorProceso;
    protected String estadoSubproceso;
    protected ProcesosEntity idProcesos;
    protected int idSubproceso;
    protected String nombreSubproceso;

    /**
     * Obtiene el valor de la propiedad actualizadorProceso.
     * 
     */
    public int getActualizadorProceso() {
        return actualizadorProceso;
    }

    /**
     * Define el valor de la propiedad actualizadorProceso.
     * 
     */
    public void setActualizadorProceso(int value) {
        this.actualizadorProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorProceso.
     * 
     */
    public int getCreadorProceso() {
        return creadorProceso;
    }

    /**
     * Define el valor de la propiedad creadorProceso.
     * 
     */
    public void setCreadorProceso(int value) {
        this.creadorProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSubproceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSubproceso() {
        return estadoSubproceso;
    }

    /**
     * Define el valor de la propiedad estadoSubproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSubproceso(String value) {
        this.estadoSubproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idProcesos.
     * 
     * @return
     *     possible object is
     *     {@link ProcesosEntity }
     *     
     */
    public ProcesosEntity getIdProcesos() {
        return idProcesos;
    }

    /**
     * Define el valor de la propiedad idProcesos.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesosEntity }
     *     
     */
    public void setIdProcesos(ProcesosEntity value) {
        this.idProcesos = value;
    }

    /**
     * Obtiene el valor de la propiedad idSubproceso.
     * 
     */
    public int getIdSubproceso() {
        return idSubproceso;
    }

    /**
     * Define el valor de la propiedad idSubproceso.
     * 
     */
    public void setIdSubproceso(int value) {
        this.idSubproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSubproceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSubproceso() {
        return nombreSubproceso;
    }

    /**
     * Define el valor de la propiedad nombreSubproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSubproceso(String value) {
        this.nombreSubproceso = value;
    }

}
