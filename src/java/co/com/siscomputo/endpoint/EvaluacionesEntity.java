
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluacionesEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evaluacionesEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="anioEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contratoEvaluaciones" type="{http://endpoint.siscomputo.com.co/}contratosEntity" minOccurs="0"/>
 *         &lt;element name="documentoEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empresaEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoProveedorEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="periodoEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proveedoresEntity" type="{http://endpoint.siscomputo.com.co/}proveedoresEntity" minOccurs="0"/>
 *         &lt;element name="responsableEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoEvaluacionEntity" type="{http://endpoint.siscomputo.com.co/}tipoEvaluacionEntity" minOccurs="0"/>
 *         &lt;element name="tipoProveedorEntity" type="{http://endpoint.siscomputo.com.co/}tipoProveedorEntity" minOccurs="0"/>
 *         &lt;element name="ubicacionEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unidadNegocioEvaluaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluacionesEntity", propOrder = {
    "anioEvaluaciones",
    "contratoEvaluaciones",
    "documentoEvaluaciones",
    "empresaEvaluaciones",
    "estadoProveedorEvaluaciones",
    "fechaEvaluaciones",
    "idEvaluaciones",
    "periodoEvaluaciones",
    "proveedoresEntity",
    "responsableEvaluaciones",
    "tipoEvaluacionEntity",
    "tipoProveedorEntity",
    "ubicacionEvaluaciones",
    "unidadNegocioEvaluaciones"
})
public class EvaluacionesEntity
    extends ObjetoRetornaEntity
{

    protected String anioEvaluaciones;
    protected ContratosEntity contratoEvaluaciones;
    protected String documentoEvaluaciones;
    protected String empresaEvaluaciones;
    protected String estadoProveedorEvaluaciones;
    protected String fechaEvaluaciones;
    @XmlElement(name = "IDEvaluaciones")
    protected int idEvaluaciones;
    protected String periodoEvaluaciones;
    protected ProveedoresEntity proveedoresEntity;
    protected String responsableEvaluaciones;
    protected TipoEvaluacionEntity tipoEvaluacionEntity;
    protected TipoProveedorEntity tipoProveedorEntity;
    protected String ubicacionEvaluaciones;
    protected String unidadNegocioEvaluaciones;

    /**
     * Obtiene el valor de la propiedad anioEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnioEvaluaciones() {
        return anioEvaluaciones;
    }

    /**
     * Define el valor de la propiedad anioEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnioEvaluaciones(String value) {
        this.anioEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad contratoEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link ContratosEntity }
     *     
     */
    public ContratosEntity getContratoEvaluaciones() {
        return contratoEvaluaciones;
    }

    /**
     * Define el valor de la propiedad contratoEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratosEntity }
     *     
     */
    public void setContratoEvaluaciones(ContratosEntity value) {
        this.contratoEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoEvaluaciones() {
        return documentoEvaluaciones;
    }

    /**
     * Define el valor de la propiedad documentoEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoEvaluaciones(String value) {
        this.documentoEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad empresaEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaEvaluaciones() {
        return empresaEvaluaciones;
    }

    /**
     * Define el valor de la propiedad empresaEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaEvaluaciones(String value) {
        this.empresaEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoProveedorEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoProveedorEvaluaciones() {
        return estadoProveedorEvaluaciones;
    }

    /**
     * Define el valor de la propiedad estadoProveedorEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoProveedorEvaluaciones(String value) {
        this.estadoProveedorEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEvaluaciones() {
        return fechaEvaluaciones;
    }

    /**
     * Define el valor de la propiedad fechaEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEvaluaciones(String value) {
        this.fechaEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad idEvaluaciones.
     * 
     */
    public int getIDEvaluaciones() {
        return idEvaluaciones;
    }

    /**
     * Define el valor de la propiedad idEvaluaciones.
     * 
     */
    public void setIDEvaluaciones(int value) {
        this.idEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoEvaluaciones() {
        return periodoEvaluaciones;
    }

    /**
     * Define el valor de la propiedad periodoEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoEvaluaciones(String value) {
        this.periodoEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedoresEntity.
     * 
     * @return
     *     possible object is
     *     {@link ProveedoresEntity }
     *     
     */
    public ProveedoresEntity getProveedoresEntity() {
        return proveedoresEntity;
    }

    /**
     * Define el valor de la propiedad proveedoresEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link ProveedoresEntity }
     *     
     */
    public void setProveedoresEntity(ProveedoresEntity value) {
        this.proveedoresEntity = value;
    }

    /**
     * Obtiene el valor de la propiedad responsableEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsableEvaluaciones() {
        return responsableEvaluaciones;
    }

    /**
     * Define el valor de la propiedad responsableEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsableEvaluaciones(String value) {
        this.responsableEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoEvaluacionEntity.
     * 
     * @return
     *     possible object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public TipoEvaluacionEntity getTipoEvaluacionEntity() {
        return tipoEvaluacionEntity;
    }

    /**
     * Define el valor de la propiedad tipoEvaluacionEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoEvaluacionEntity }
     *     
     */
    public void setTipoEvaluacionEntity(TipoEvaluacionEntity value) {
        this.tipoEvaluacionEntity = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoProveedorEntity.
     * 
     * @return
     *     possible object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public TipoProveedorEntity getTipoProveedorEntity() {
        return tipoProveedorEntity;
    }

    /**
     * Define el valor de la propiedad tipoProveedorEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProveedorEntity }
     *     
     */
    public void setTipoProveedorEntity(TipoProveedorEntity value) {
        this.tipoProveedorEntity = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacionEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacionEvaluaciones() {
        return ubicacionEvaluaciones;
    }

    /**
     * Define el valor de la propiedad ubicacionEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacionEvaluaciones(String value) {
        this.ubicacionEvaluaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadNegocioEvaluaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadNegocioEvaluaciones() {
        return unidadNegocioEvaluaciones;
    }

    /**
     * Define el valor de la propiedad unidadNegocioEvaluaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadNegocioEvaluaciones(String value) {
        this.unidadNegocioEvaluaciones = value;
    }

}
