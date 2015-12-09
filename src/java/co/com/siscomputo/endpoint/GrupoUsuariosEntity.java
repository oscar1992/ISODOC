
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para grupoUsuariosEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="grupoUsuariosEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorGrupoUsuarios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creaGrupoUsuarios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoGrupoUsuarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idGrupoUsuarios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreGrupoUsuarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grupoUsuariosEntity", propOrder = {
    "actualizadorGrupoUsuarios",
    "creaGrupoUsuarios",
    "estadoGrupoUsuarios",
    "idGrupoUsuarios",
    "nombreGrupoUsuarios"
})
public class GrupoUsuariosEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorGrupoUsuarios;
    protected int creaGrupoUsuarios;
    protected String estadoGrupoUsuarios;
    protected int idGrupoUsuarios;
    protected String nombreGrupoUsuarios;

    /**
     * Obtiene el valor de la propiedad actualizadorGrupoUsuarios.
     * 
     */
    public int getActualizadorGrupoUsuarios() {
        return actualizadorGrupoUsuarios;
    }

    /**
     * Define el valor de la propiedad actualizadorGrupoUsuarios.
     * 
     */
    public void setActualizadorGrupoUsuarios(int value) {
        this.actualizadorGrupoUsuarios = value;
    }

    /**
     * Obtiene el valor de la propiedad creaGrupoUsuarios.
     * 
     */
    public int getCreaGrupoUsuarios() {
        return creaGrupoUsuarios;
    }

    /**
     * Define el valor de la propiedad creaGrupoUsuarios.
     * 
     */
    public void setCreaGrupoUsuarios(int value) {
        this.creaGrupoUsuarios = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoGrupoUsuarios.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoGrupoUsuarios() {
        return estadoGrupoUsuarios;
    }

    /**
     * Define el valor de la propiedad estadoGrupoUsuarios.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoGrupoUsuarios(String value) {
        this.estadoGrupoUsuarios = value;
    }

    /**
     * Obtiene el valor de la propiedad idGrupoUsuarios.
     * 
     */
    public int getIdGrupoUsuarios() {
        return idGrupoUsuarios;
    }

    /**
     * Define el valor de la propiedad idGrupoUsuarios.
     * 
     */
    public void setIdGrupoUsuarios(int value) {
        this.idGrupoUsuarios = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreGrupoUsuarios.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreGrupoUsuarios() {
        return nombreGrupoUsuarios;
    }

    /**
     * Define el valor de la propiedad nombreGrupoUsuarios.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreGrupoUsuarios(String value) {
        this.nombreGrupoUsuarios = value;
    }

}
