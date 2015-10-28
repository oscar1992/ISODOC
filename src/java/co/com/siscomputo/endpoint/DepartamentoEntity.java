
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para departamentoEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="departamentoEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorDepartamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigoDepartamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorDepartamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoDepartamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDepartamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPais" type="{http://endpoint.siscomputo.com.co/}paisEntity" minOccurs="0"/>
 *         &lt;element name="nombreDepartamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "departamentoEntity", propOrder = {
    "actualizadorDepartamento",
    "codigoDepartamento",
    "creadorDepartamento",
    "estadoDepartamento",
    "idDepartamento",
    "idPais",
    "nombreDepartamento"
})
public class DepartamentoEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorDepartamento;
    protected int codigoDepartamento;
    protected int creadorDepartamento;
    protected String estadoDepartamento;
    protected int idDepartamento;
    protected PaisEntity idPais;
    protected String nombreDepartamento;

    /**
     * Obtiene el valor de la propiedad actualizadorDepartamento.
     * 
     */
    public int getActualizadorDepartamento() {
        return actualizadorDepartamento;
    }

    /**
     * Define el valor de la propiedad actualizadorDepartamento.
     * 
     */
    public void setActualizadorDepartamento(int value) {
        this.actualizadorDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDepartamento.
     * 
     */
    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * Define el valor de la propiedad codigoDepartamento.
     * 
     */
    public void setCodigoDepartamento(int value) {
        this.codigoDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorDepartamento.
     * 
     */
    public int getCreadorDepartamento() {
        return creadorDepartamento;
    }

    /**
     * Define el valor de la propiedad creadorDepartamento.
     * 
     */
    public void setCreadorDepartamento(int value) {
        this.creadorDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoDepartamento() {
        return estadoDepartamento;
    }

    /**
     * Define el valor de la propiedad estadoDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoDepartamento(String value) {
        this.estadoDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad idDepartamento.
     * 
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * Define el valor de la propiedad idDepartamento.
     * 
     */
    public void setIdDepartamento(int value) {
        this.idDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad idPais.
     * 
     * @return
     *     possible object is
     *     {@link PaisEntity }
     *     
     */
    public PaisEntity getIdPais() {
        return idPais;
    }

    /**
     * Define el valor de la propiedad idPais.
     * 
     * @param value
     *     allowed object is
     *     {@link PaisEntity }
     *     
     */
    public void setIdPais(PaisEntity value) {
        this.idPais = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * Define el valor de la propiedad nombreDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDepartamento(String value) {
        this.nombreDepartamento = value;
    }

}
