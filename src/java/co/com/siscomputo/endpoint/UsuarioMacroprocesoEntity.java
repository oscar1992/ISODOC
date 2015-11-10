
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioMacroprocesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioMacroprocesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoTraza">
 *       &lt;sequence>
 *         &lt;element name="idMacroProceso" type="{http://endpoint.siscomputo.com.co/}macroprocesosEntity" minOccurs="0"/>
 *         &lt;element name="idUsuario" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *         &lt;element name="idUsuarioMacroproceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioMacroprocesoEntity", propOrder = {
    "idMacroProceso",
    "idUsuario",
    "idUsuarioMacroproceso"
})
public class UsuarioMacroprocesoEntity
    extends ObjetoTraza
{

    protected MacroprocesosEntity idMacroProceso;
    protected UsuarioEntity idUsuario;
    protected int idUsuarioMacroproceso;

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
     * Obtiene el valor de la propiedad idUsuarioMacroproceso.
     * 
     */
    public int getIdUsuarioMacroproceso() {
        return idUsuarioMacroproceso;
    }

    /**
     * Define el valor de la propiedad idUsuarioMacroproceso.
     * 
     */
    public void setIdUsuarioMacroproceso(int value) {
        this.idUsuarioMacroproceso = value;
    }

}
