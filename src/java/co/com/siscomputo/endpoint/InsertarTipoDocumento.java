
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarTipoDocumento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarTipoDocumento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoDocumentoObjeto" type="{http://endpoint.siscomputo.com.co/}tipoDocumentoEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarTipoDocumento", propOrder = {
    "tipoDocumentoObjeto"
})
public class InsertarTipoDocumento {

    @XmlElement(name = "TipoDocumentoObjeto")
    protected TipoDocumentoEntity tipoDocumentoObjeto;

    /**
     * Obtiene el valor de la propiedad tipoDocumentoObjeto.
     * 
     * @return
     *     possible object is
     *     {@link TipoDocumentoEntity }
     *     
     */
    public TipoDocumentoEntity getTipoDocumentoObjeto() {
        return tipoDocumentoObjeto;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDocumentoEntity }
     *     
     */
    public void setTipoDocumentoObjeto(TipoDocumentoEntity value) {
        this.tipoDocumentoObjeto = value;
    }

}
