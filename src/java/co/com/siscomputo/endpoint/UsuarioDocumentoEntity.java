
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuarioDocumentoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioDocumentoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="documentoUsuarioDocumento" type="{http://endpoint.siscomputo.com.co/}documentoEntity" minOccurs="0"/>
 *         &lt;element name="idUsuarioDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuarioUsuarioDocumento" type="{http://endpoint.siscomputo.com.co/}usuarioEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioDocumentoEntity", propOrder = {
    "documentoUsuarioDocumento",
    "idUsuarioDocumento",
    "usuarioUsuarioDocumento"
})
public class UsuarioDocumentoEntity
    extends ObjetoRetornaEntity
{

    protected DocumentoEntity documentoUsuarioDocumento;
    protected int idUsuarioDocumento;
    protected UsuarioEntity usuarioUsuarioDocumento;

    /**
     * Obtiene el valor de la propiedad documentoUsuarioDocumento.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoEntity }
     *     
     */
    public DocumentoEntity getDocumentoUsuarioDocumento() {
        return documentoUsuarioDocumento;
    }

    /**
     * Define el valor de la propiedad documentoUsuarioDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoEntity }
     *     
     */
    public void setDocumentoUsuarioDocumento(DocumentoEntity value) {
        this.documentoUsuarioDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioDocumento.
     * 
     */
    public int getIdUsuarioDocumento() {
        return idUsuarioDocumento;
    }

    /**
     * Define el valor de la propiedad idUsuarioDocumento.
     * 
     */
    public void setIdUsuarioDocumento(int value) {
        this.idUsuarioDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioUsuarioDocumento.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioEntity }
     *     
     */
    public UsuarioEntity getUsuarioUsuarioDocumento() {
        return usuarioUsuarioDocumento;
    }

    /**
     * Define el valor de la propiedad usuarioUsuarioDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioEntity }
     *     
     */
    public void setUsuarioUsuarioDocumento(UsuarioEntity value) {
        this.usuarioUsuarioDocumento = value;
    }

}
