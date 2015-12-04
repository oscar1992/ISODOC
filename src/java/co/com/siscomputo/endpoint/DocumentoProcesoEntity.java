
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para documentoProcesoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="documentoProcesoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="accionDocumentoProceso" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *         &lt;element name="documentoDocumentoProceso" type="{http://endpoint.siscomputo.com.co/}documentoEntity" minOccurs="0"/>
 *         &lt;element name="fechaDocumentoProceso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idDocumentoProceso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuarioDocumentoProceso" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoProcesoEntity", propOrder = {
    "accionDocumentoProceso",
    "documentoDocumentoProceso",
    "fechaDocumentoProceso",
    "idDocumentoProceso",
    "usuarioDocumentoProceso"
})
public class DocumentoProcesoEntity
    extends ObjetoRetornaEntity
{

    protected AccionEntity accionDocumentoProceso;
    protected DocumentoEntity documentoDocumentoProceso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDocumentoProceso;
    protected int idDocumentoProceso;
    protected UsuarioEntity usuarioDocumentoProceso;

    /**
     * Obtiene el valor de la propiedad accionDocumentoProceso.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getAccionDocumentoProceso() {
        return accionDocumentoProceso;
    }

    /**
     * Define el valor de la propiedad accionDocumentoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setAccionDocumentoProceso(AccionEntity value) {
        this.accionDocumentoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoDocumentoProceso.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoEntity }
     *     
     */
    public DocumentoEntity getDocumentoDocumentoProceso() {
        return documentoDocumentoProceso;
    }

    /**
     * Define el valor de la propiedad documentoDocumentoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoEntity }
     *     
     */
    public void setDocumentoDocumentoProceso(DocumentoEntity value) {
        this.documentoDocumentoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDocumentoProceso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDocumentoProceso() {
        return fechaDocumentoProceso;
    }

    /**
     * Define el valor de la propiedad fechaDocumentoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDocumentoProceso(XMLGregorianCalendar value) {
        this.fechaDocumentoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentoProceso.
     * 
     */
    public int getIdDocumentoProceso() {
        return idDocumentoProceso;
    }

    /**
     * Define el valor de la propiedad idDocumentoProceso.
     * 
     */
    public void setIdDocumentoProceso(int value) {
        this.idDocumentoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioDocumentoProceso.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuarioDocumentoProceso() {
        return usuarioDocumentoProceso;
    }

    /**
     * Define el valor de la propiedad usuarioDocumentoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuarioDocumentoProceso(UsuarioEntity value) {
        this.usuarioDocumentoProceso = value;
    }

}
