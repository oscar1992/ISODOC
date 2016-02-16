
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anexoContratoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="anexoContratoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idAnexo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idContratoAnexo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ubicacionAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anexoContratoEntity", propOrder = {
    "idAnexo",
    "idContratoAnexo",
    "ubicacionAnexo"
})
public class AnexoContratoEntity
    extends ObjetoRetornaEntity
{

    protected Integer idAnexo;
    protected Integer idContratoAnexo;
    protected String ubicacionAnexo;

    /**
     * Obtiene el valor de la propiedad idAnexo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdAnexo() {
        return idAnexo;
    }

    /**
     * Define el valor de la propiedad idAnexo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdAnexo(Integer value) {
        this.idAnexo = value;
    }

    /**
     * Obtiene el valor de la propiedad idContratoAnexo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContratoAnexo() {
        return idContratoAnexo;
    }

    /**
     * Define el valor de la propiedad idContratoAnexo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContratoAnexo(Integer value) {
        this.idContratoAnexo = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacionAnexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacionAnexo() {
        return ubicacionAnexo;
    }

    /**
     * Define el valor de la propiedad ubicacionAnexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacionAnexo(String value) {
        this.ubicacionAnexo = value;
    }

}
