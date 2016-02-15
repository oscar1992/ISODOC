
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarCertificado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarCertificado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertificadoEntity" type="{http://endpoint.siscomputo.com.co/}certificadoCalidadEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarCertificado", propOrder = {
    "certificadoEntity"
})
public class InsertarCertificado {

    @XmlElement(name = "CertificadoEntity")
    protected CertificadoCalidadEntity certificadoEntity;

    /**
     * Obtiene el valor de la propiedad certificadoEntity.
     * 
     * @return
     *     possible object is
     *     {@link CertificadoCalidadEntity }
     *     
     */
    public CertificadoCalidadEntity getCertificadoEntity() {
        return certificadoEntity;
    }

    /**
     * Define el valor de la propiedad certificadoEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificadoCalidadEntity }
     *     
     */
    public void setCertificadoEntity(CertificadoCalidadEntity value) {
        this.certificadoEntity = value;
    }

}
