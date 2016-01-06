
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para documentoRolEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="documentoRolEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="controlDocumentoRol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="copiaDocumentoRol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentoentityDocumentoRol" type="{http://endpoint.siscomputo.com.co/}documentoEntity" minOccurs="0"/>
 *         &lt;element name="idDocumentoRol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rolesentityDocumentoRol" type="{http://endpoint.siscomputo.com.co/}rolesEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoRolEntity", propOrder = {
    "controlDocumentoRol",
    "copiaDocumentoRol",
    "documentoentityDocumentoRol",
    "idDocumentoRol",
    "rolesentityDocumentoRol"
})
public class DocumentoRolEntity
    extends ObjetoRetornaEntity
{

    protected String controlDocumentoRol;
    protected String copiaDocumentoRol;
    protected DocumentoEntity documentoentityDocumentoRol;
    protected int idDocumentoRol;
    protected RolesEntity rolesentityDocumentoRol;

    /**
     * Obtiene el valor de la propiedad controlDocumentoRol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlDocumentoRol() {
        return controlDocumentoRol;
    }

    /**
     * Define el valor de la propiedad controlDocumentoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlDocumentoRol(String value) {
        this.controlDocumentoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad copiaDocumentoRol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopiaDocumentoRol() {
        return copiaDocumentoRol;
    }

    /**
     * Define el valor de la propiedad copiaDocumentoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopiaDocumentoRol(String value) {
        this.copiaDocumentoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoentityDocumentoRol.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoEntity }
     *     
     */
    public DocumentoEntity getDocumentoentityDocumentoRol() {
        return documentoentityDocumentoRol;
    }

    /**
     * Define el valor de la propiedad documentoentityDocumentoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoEntity }
     *     
     */
    public void setDocumentoentityDocumentoRol(DocumentoEntity value) {
        this.documentoentityDocumentoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentoRol.
     * 
     */
    public int getIdDocumentoRol() {
        return idDocumentoRol;
    }

    /**
     * Define el valor de la propiedad idDocumentoRol.
     * 
     */
    public void setIdDocumentoRol(int value) {
        this.idDocumentoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad rolesentityDocumentoRol.
     * 
     * @return
     *     possible object is
     *     {@link RolesEntity }
     *     
     */
    public RolesEntity getRolesentityDocumentoRol() {
        return rolesentityDocumentoRol;
    }

    /**
     * Define el valor de la propiedad rolesentityDocumentoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link RolesEntity }
     *     
     */
    public void setRolesentityDocumentoRol(RolesEntity value) {
        this.rolesentityDocumentoRol = value;
    }

}
