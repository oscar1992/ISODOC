
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para documentoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="documentoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="accionDocumento" type="{http://endpoint.siscomputo.com.co/}accionEntity" minOccurs="0"/>
 *         &lt;element name="empresaDocumento" type="{http://endpoint.siscomputo.com.co/}empresaEntity" minOccurs="0"/>
 *         &lt;element name="estadoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaDocumento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="plantilla" type="{http://endpoint.siscomputo.com.co/}plantillaEntity" minOccurs="0"/>
 *         &lt;element name="procesoDocumento" type="{http://endpoint.siscomputo.com.co/}procesoEntity" minOccurs="0"/>
 *         &lt;element name="rutaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDocumentalDocumento" type="{http://endpoint.siscomputo.com.co/}tiposDocumentalesEntity" minOccurs="0"/>
 *         &lt;element name="tituloDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoEntity", propOrder = {
    "accionDocumento",
    "empresaDocumento",
    "estadoDocumento",
    "fechaDocumento",
    "idDocumento",
    "plantilla",
    "procesoDocumento",
    "rutaDocumento",
    "tipoDocumentalDocumento",
    "tituloDocumento",
    "versionDocumento"
})
public class DocumentoEntity
    extends ObjetoRetornaEntity
{

    protected AccionEntity accionDocumento;
    protected EmpresaEntity empresaDocumento;
    protected String estadoDocumento;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDocumento;
    protected int idDocumento;
    protected PlantillaEntity plantilla;
    protected ProcesoEntity procesoDocumento;
    protected String rutaDocumento;
    protected TiposDocumentalesEntity tipoDocumentalDocumento;
    protected String tituloDocumento;
    protected String versionDocumento;

    /**
     * Obtiene el valor de la propiedad accionDocumento.
     * 
     * @return
     *     possible object is
     *     {@link AccionEntity }
     *     
     */
    public AccionEntity getAccionDocumento() {
        return accionDocumento;
    }

    /**
     * Define el valor de la propiedad accionDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link AccionEntity }
     *     
     */
    public void setAccionDocumento(AccionEntity value) {
        this.accionDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad empresaDocumento.
     * 
     * @return
     *     possible object is
     *     {@link EmpresaEntity }
     *     
     */
    public EmpresaEntity getEmpresaDocumento() {
        return empresaDocumento;
    }

    /**
     * Define el valor de la propiedad empresaDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link EmpresaEntity }
     *     
     */
    public void setEmpresaDocumento(EmpresaEntity value) {
        this.empresaDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    /**
     * Define el valor de la propiedad estadoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoDocumento(String value) {
        this.estadoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDocumento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDocumento() {
        return fechaDocumento;
    }

    /**
     * Define el valor de la propiedad fechaDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDocumento(XMLGregorianCalendar value) {
        this.fechaDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumento.
     * 
     */
    public int getIdDocumento() {
        return idDocumento;
    }

    /**
     * Define el valor de la propiedad idDocumento.
     * 
     */
    public void setIdDocumento(int value) {
        this.idDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad plantilla.
     * 
     * @return
     *     possible object is
     *     {@link PlantillaEntity }
     *     
     */
    public PlantillaEntity getPlantilla() {
        return plantilla;
    }

    /**
     * Define el valor de la propiedad plantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link PlantillaEntity }
     *     
     */
    public void setPlantilla(PlantillaEntity value) {
        this.plantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad procesoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link ProcesoEntity }
     *     
     */
    public ProcesoEntity getProcesoDocumento() {
        return procesoDocumento;
    }

    /**
     * Define el valor de la propiedad procesoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesoEntity }
     *     
     */
    public void setProcesoDocumento(ProcesoEntity value) {
        this.procesoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaDocumento() {
        return rutaDocumento;
    }

    /**
     * Define el valor de la propiedad rutaDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaDocumento(String value) {
        this.rutaDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentalDocumento.
     * 
     * @return
     *     possible object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public TiposDocumentalesEntity getTipoDocumentalDocumento() {
        return tipoDocumentalDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumentalDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link TiposDocumentalesEntity }
     *     
     */
    public void setTipoDocumentalDocumento(TiposDocumentalesEntity value) {
        this.tipoDocumentalDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad tituloDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTituloDocumento() {
        return tituloDocumento;
    }

    /**
     * Define el valor de la propiedad tituloDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTituloDocumento(String value) {
        this.tituloDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad versionDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionDocumento() {
        return versionDocumento;
    }

    /**
     * Define el valor de la propiedad versionDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionDocumento(String value) {
        this.versionDocumento = value;
    }

}
