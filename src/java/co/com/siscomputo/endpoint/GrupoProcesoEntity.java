
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para grupoProcesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="grupoProcesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="accionGrupoProceso" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *         &lt;element name="grupoUsuarioProceso" type="{http://endpoint.siscomputo.com.co/}grupoUsuariosEntity" minOccurs="0"/>
 *         &lt;element name="idGrupoProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="procesoGrupoProceso" type="{http://endpoint.siscomputo.com.co/}procesoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grupoProcesoEntity", propOrder = {
    "accionGrupoProceso",
    "grupoUsuarioProceso",
    "idGrupoProceso",
    "procesoGrupoProceso"
})
public class GrupoProcesoEntity
    extends ObjetoRetornaEntity
{

    protected AccionEntity accionGrupoProceso;
    protected GrupoUsuariosEntity grupoUsuarioProceso;
    protected int idGrupoProceso;
    protected ProcesoEntity procesoGrupoProceso;

    /**
     * Obtiene el valor de la propiedad accionGrupoProceso.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getAccionGrupoProceso() {
        return accionGrupoProceso;
    }

    /**
     * Define el valor de la propiedad accionGrupoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setAccionGrupoProceso(AccionEntity value) {
        this.accionGrupoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad grupoUsuarioProceso.
     * 
     * @return
     *     possible object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public GrupoUsuariosEntity getGrupoUsuarioProceso() {
        return grupoUsuarioProceso;
    }

    /**
     * Define el valor de la propiedad grupoUsuarioProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public void setGrupoUsuarioProceso(GrupoUsuariosEntity value) {
        this.grupoUsuarioProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idGrupoProceso.
     * 
     */
    public int getIdGrupoProceso() {
        return idGrupoProceso;
    }

    /**
     * Define el valor de la propiedad idGrupoProceso.
     * 
     */
    public void setIdGrupoProceso(int value) {
        this.idGrupoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad procesoGrupoProceso.
     * 
     * @return
     *     possible object is
     *     {@link ProcesoEntity }
     *     
     */
    public ProcesoEntity getProcesoGrupoProceso() {
        return procesoGrupoProceso;
    }

    /**
     * Define el valor de la propiedad procesoGrupoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesoEntity }
     *     
     */
    public void setProcesoGrupoProceso(ProcesoEntity value) {
        this.procesoGrupoProceso = value;
    }

}
