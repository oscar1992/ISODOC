
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para polizasEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="polizasEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idContratoPoliza" type="{http://endpoint.siscomputo.com.co/}contratosEntity" minOccurs="0"/>
 *         &lt;element name="idPoliza" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numeroPoliza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "polizasEntity", propOrder = {
    "idContratoPoliza",
    "idPoliza",
    "numeroPoliza"
})
public class PolizasEntity
    extends ObjetoRetornaEntity
{

    protected ContratosEntity idContratoPoliza;
    protected Integer idPoliza;
    protected String numeroPoliza;

    /**
     * Obtiene el valor de la propiedad idContratoPoliza.
     * 
     * @return
     *     possible object is
     *     {@link ContratosEntity }
     *     
     */
    public ContratosEntity getIdContratoPoliza() {
        return idContratoPoliza;
    }

    /**
     * Define el valor de la propiedad idContratoPoliza.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratosEntity }
     *     
     */
    public void setIdContratoPoliza(ContratosEntity value) {
        this.idContratoPoliza = value;
    }

    /**
     * Obtiene el valor de la propiedad idPoliza.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPoliza() {
        return idPoliza;
    }

    /**
     * Define el valor de la propiedad idPoliza.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPoliza(Integer value) {
        this.idPoliza = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPoliza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    /**
     * Define el valor de la propiedad numeroPoliza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroPoliza(String value) {
        this.numeroPoliza = value;
    }

}
