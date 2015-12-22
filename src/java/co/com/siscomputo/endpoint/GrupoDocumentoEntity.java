
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para grupoDocumentoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="grupoDocumentoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="accionGrupoDocumento" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *         &lt;element name="documentoGrupoDocumento" type="{http://endpoint.siscomputo.com.co/}documentoEntity" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grupousuariosGrupoDocumento" type="{http://endpoint.siscomputo.com.co/}grupoUsuariosEntity" minOccurs="0"/>
 *         &lt;element name="idGrupoDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grupoDocumentoEntity", propOrder = {
    "accionGrupoDocumento",
    "documentoGrupoDocumento",
    "fecha",
    "grupousuariosGrupoDocumento",
    "idGrupoDocumento"
})
public class GrupoDocumentoEntity
    extends ObjetoRetornaEntity
{

    protected AccionEntity accionGrupoDocumento;
    protected DocumentoEntity documentoGrupoDocumento;
    protected String fecha;
    protected GrupoUsuariosEntity grupousuariosGrupoDocumento;
    protected int idGrupoDocumento;

    /**
     * Obtiene el valor de la propiedad accionGrupoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getAccionGrupoDocumento() {
        return accionGrupoDocumento;
    }

    /**
     * Define el valor de la propiedad accionGrupoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setAccionGrupoDocumento(AccionEntity value) {
        this.accionGrupoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoGrupoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoEntity }
     *     
     */
    public DocumentoEntity getDocumentoGrupoDocumento() {
        return documentoGrupoDocumento;
    }

    /**
     * Define el valor de la propiedad documentoGrupoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoEntity }
     *     
     */
    public void setDocumentoGrupoDocumento(DocumentoEntity value) {
        this.documentoGrupoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad grupousuariosGrupoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public GrupoUsuariosEntity getGrupousuariosGrupoDocumento() {
        return grupousuariosGrupoDocumento;
    }

    /**
     * Define el valor de la propiedad grupousuariosGrupoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoUsuariosEntity }
     *     
     */
    public void setGrupousuariosGrupoDocumento(GrupoUsuariosEntity value) {
        this.grupousuariosGrupoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad idGrupoDocumento.
     * 
     */
    public int getIdGrupoDocumento() {
        return idGrupoDocumento;
    }

    /**
     * Define el valor de la propiedad idGrupoDocumento.
     * 
     */
    public void setIdGrupoDocumento(int value) {
        this.idGrupoDocumento = value;
    }

}
