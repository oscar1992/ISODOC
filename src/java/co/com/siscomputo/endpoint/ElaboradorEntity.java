
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para elaboradorEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="elaboradorEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorElaborador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorElaborador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoElaborador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idElaborador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuarioElaborador" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elaboradorEntity", propOrder = {
    "actualizadorElaborador",
    "creadorElaborador",
    "estadoElaborador",
    "idElaborador",
    "usuarioElaborador"
})
public class ElaboradorEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorElaborador;
    protected int creadorElaborador;
    protected String estadoElaborador;
    protected int idElaborador;
    protected UsuarioEntity usuarioElaborador;

    /**
     * Obtiene el valor de la propiedad actualizadorElaborador.
     * 
     */
    public int getActualizadorElaborador() {
        return actualizadorElaborador;
    }

    /**
     * Define el valor de la propiedad actualizadorElaborador.
     * 
     */
    public void setActualizadorElaborador(int value) {
        this.actualizadorElaborador = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorElaborador.
     * 
     */
    public int getCreadorElaborador() {
        return creadorElaborador;
    }

    /**
     * Define el valor de la propiedad creadorElaborador.
     * 
     */
    public void setCreadorElaborador(int value) {
        this.creadorElaborador = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoElaborador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoElaborador() {
        return estadoElaborador;
    }

    /**
     * Define el valor de la propiedad estadoElaborador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoElaborador(String value) {
        this.estadoElaborador = value;
    }

    /**
     * Obtiene el valor de la propiedad idElaborador.
     * 
     */
    public int getIdElaborador() {
        return idElaborador;
    }

    /**
     * Define el valor de la propiedad idElaborador.
     * 
     */
    public void setIdElaborador(int value) {
        this.idElaborador = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioElaborador.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuarioElaborador() {
        return usuarioElaborador;
    }

    /**
     * Define el valor de la propiedad usuarioElaborador.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuarioElaborador(UsuarioEntity value) {
        this.usuarioElaborador = value;
    }

}
