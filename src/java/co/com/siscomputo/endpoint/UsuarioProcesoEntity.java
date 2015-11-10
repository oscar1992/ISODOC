
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioProcesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioProcesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="idProceso" type="{http://endpoint.siscomputo.com.co/}procesosEntity" minOccurs="0"/>
 *         &lt;element name="idUsuario" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *         &lt;element name="idUsuarioProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioProcesoEntity", propOrder = {
    "idProceso",
    "idUsuario",
    "idUsuarioProceso"
})
public class UsuarioProcesoEntity
    extends ObjetoTraza
{

    protected ProcesosEntity idProceso;
    protected UsuarioEntity idUsuario;
    protected int idUsuarioProceso;

    /**
     * Obtiene el valor de la propiedad idProceso.
     * 
     * @return
     *     possible object is
     *     {@link ProcesosEntity }
     *     
     */
    public ProcesosEntity getIdProceso() {
        return idProceso;
    }

    /**
     * Define el valor de la propiedad idProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesosEntity }
     *     
     */
    public void setIdProceso(ProcesosEntity value) {
        this.idProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setIdUsuario(UsuarioEntity value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioProceso.
     * 
     */
    public int getIdUsuarioProceso() {
        return idUsuarioProceso;
    }

    /**
     * Define el valor de la propiedad idUsuarioProceso.
     * 
     */
    public void setIdUsuarioProceso(int value) {
        this.idUsuarioProceso = value;
    }

}
