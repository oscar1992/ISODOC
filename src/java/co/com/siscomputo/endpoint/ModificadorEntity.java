
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificadorEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificadorEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorModificador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorModificador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoModificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idModificador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuarioModificador" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificadorEntity", propOrder = {
    "actualizadorModificador",
    "creadorModificador",
    "estadoModificador",
    "idModificador",
    "usuarioModificador"
})
public class ModificadorEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorModificador;
    protected int creadorModificador;
    protected String estadoModificador;
    protected int idModificador;
    protected UsuarioEntity usuarioModificador;

    /**
     * Obtiene el valor de la propiedad actualizadorModificador.
     * 
     */
    public int getActualizadorModificador() {
        return actualizadorModificador;
    }

    /**
     * Define el valor de la propiedad actualizadorModificador.
     * 
     */
    public void setActualizadorModificador(int value) {
        this.actualizadorModificador = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorModificador.
     * 
     */
    public int getCreadorModificador() {
        return creadorModificador;
    }

    /**
     * Define el valor de la propiedad creadorModificador.
     * 
     */
    public void setCreadorModificador(int value) {
        this.creadorModificador = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoModificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoModificador() {
        return estadoModificador;
    }

    /**
     * Define el valor de la propiedad estadoModificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoModificador(String value) {
        this.estadoModificador = value;
    }

    /**
     * Obtiene el valor de la propiedad idModificador.
     * 
     */
    public int getIdModificador() {
        return idModificador;
    }

    /**
     * Define el valor de la propiedad idModificador.
     * 
     */
    public void setIdModificador(int value) {
        this.idModificador = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioModificador.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuarioModificador() {
        return usuarioModificador;
    }

    /**
     * Define el valor de la propiedad usuarioModificador.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuarioModificador(UsuarioEntity value) {
        this.usuarioModificador = value;
    }

}
