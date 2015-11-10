
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para procesosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="procesosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="actualizadorProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMacroProceso" type="{http://endpoint.siscomputo.com.co/}macroprocesosEntity" minOccurs="0"/>
 *         &lt;element name="idProcesos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombrePreoceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procesosEntity", propOrder = {
    "actualizadorProceso",
    "creadorProceso",
    "estadoProceso",
    "idMacroProceso",
    "idProcesos",
    "nombrePreoceso"
})
public class ProcesosEntity
    extends ObjetoTraza
{

    protected int actualizadorProceso;
    protected int creadorProceso;
    protected String estadoProceso;
    protected MacroprocesosEntity idMacroProceso;
    protected int idProcesos;
    protected String nombrePreoceso;

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
     * Obtiene el valor de la propiedad idMacroProceso.
     * 
     * @return
     *     possible object is
     *     {@link MacroprocesosEntity }
     *     
     */
    public MacroprocesosEntity getIdMacroProceso() {
        return idMacroProceso;
    }

    /**
     * Define el valor de la propiedad idMacroProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link MacroprocesosEntity }
     *     
     */
    public void setIdMacroProceso(MacroprocesosEntity value) {
        this.idMacroProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idProcesos.
     * 
     */
    public int getIdProcesos() {
        return idProcesos;
    }

    /**
     * Define el valor de la propiedad idProcesos.
     * 
     */
    public void setIdProcesos(int value) {
        this.idProcesos = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePreoceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePreoceso() {
        return nombrePreoceso;
    }

    /**
     * Define el valor de la propiedad nombrePreoceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePreoceso(String value) {
        this.nombrePreoceso = value;
    }

}
