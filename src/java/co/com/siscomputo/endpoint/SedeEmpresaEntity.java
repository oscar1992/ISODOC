
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sedeEmpresaEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sedeEmpresaEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="idEmpresa" type="{http://endpoint.siscomputo.com.co/}empresaEntity" minOccurs="0"/>
 *         &lt;element name="idSede" type="{http://endpoint.siscomputo.com.co/}sedeEntity" minOccurs="0"/>
 *         &lt;element name="idSedeEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sedeEmpresaEntity", propOrder = {
    "idEmpresa",
    "idSede",
    "idSedeEmpresa"
})
public class SedeEmpresaEntity
    extends ObjetoRetornaEntity
{

    protected EmpresaEntity idEmpresa;
    protected SedeEntity idSede;
    protected int idSedeEmpresa;

    /**
     * Obtiene el valor de la propiedad idEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link EmpresaEntity }
     *     
     */
    public EmpresaEntity getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Define el valor de la propiedad idEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link EmpresaEntity }
     *     
     */
    public void setIdEmpresa(EmpresaEntity value) {
        this.idEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad idSede.
     * 
     * @return
     *     possible object is
     *     {@link SedeEntity }
     *     
     */
    public SedeEntity getIdSede() {
        return idSede;
    }

    /**
     * Define el valor de la propiedad idSede.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeEntity }
     *     
     */
    public void setIdSede(SedeEntity value) {
        this.idSede = value;
    }

    /**
     * Obtiene el valor de la propiedad idSedeEmpresa.
     * 
     */
    public int getIdSedeEmpresa() {
        return idSedeEmpresa;
    }

    /**
     * Define el valor de la propiedad idSedeEmpresa.
     * 
     */
    public void setIdSedeEmpresa(int value) {
        this.idSedeEmpresa = value;
    }

}
