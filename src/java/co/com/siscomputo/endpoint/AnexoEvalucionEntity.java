
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anexoEvalucionEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="anexoEvalucionEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idAnexoEvalucion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idEvalucion" type="{http://endpoint.siscomputo.com.co/}evaluacionesEntity" minOccurs="0"/>
 *         &lt;element name="rutaAnexoEvalucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anexoEvalucionEntity", propOrder = {
    "idAnexoEvalucion",
    "idEvalucion",
    "rutaAnexoEvalucion"
})
public class AnexoEvalucionEntity
    extends ObjetoRetornaEntity
{

    protected int idAnexoEvalucion;
    protected EvaluacionesEntity idEvalucion;
    protected String rutaAnexoEvalucion;

    /**
     * Obtiene el valor de la propiedad idAnexoEvalucion.
     * 
     */
    public int getIdAnexoEvalucion() {
        return idAnexoEvalucion;
    }

    /**
     * Define el valor de la propiedad idAnexoEvalucion.
     * 
     */
    public void setIdAnexoEvalucion(int value) {
        this.idAnexoEvalucion = value;
    }

    /**
     * Obtiene el valor de la propiedad idEvalucion.
     * 
     * @return
     *     possible object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public EvaluacionesEntity getIdEvalucion() {
        return idEvalucion;
    }

    /**
     * Define el valor de la propiedad idEvalucion.
     * 
     * @param value
     *     allowed object is
     *     {@link EvaluacionesEntity }
     *     
     */
    public void setIdEvalucion(EvaluacionesEntity value) {
        this.idEvalucion = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaAnexoEvalucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaAnexoEvalucion() {
        return rutaAnexoEvalucion;
    }

    /**
     * Define el valor de la propiedad rutaAnexoEvalucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaAnexoEvalucion(String value) {
        this.rutaAnexoEvalucion = value;
    }

}
