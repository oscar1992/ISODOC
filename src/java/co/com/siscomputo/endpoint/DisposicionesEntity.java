
package co.com.siscomputo.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para disposicionesEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="disposicionesEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.siscomputo.com.co/}objetoRetornaEntity">
 *       &lt;sequence>
 *         &lt;element name="actualizadorDispocisiones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creadorDisposiciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoDisposiciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDisposirciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreDisposiciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disposicionesEntity", propOrder = {
    "actualizadorDispocisiones",
    "creadorDisposiciones",
    "estadoDisposiciones",
    "idDisposirciones",
    "nombreDisposiciones"
})
public class DisposicionesEntity
    extends ObjetoRetornaEntity
{

    protected int actualizadorDispocisiones;
    protected int creadorDisposiciones;
    protected String estadoDisposiciones;
    protected int idDisposirciones;
    protected String nombreDisposiciones;

    /**
     * Obtiene el valor de la propiedad actualizadorDispocisiones.
     * 
     */
    public int getActualizadorDispocisiones() {
        return actualizadorDispocisiones;
    }

    /**
     * Define el valor de la propiedad actualizadorDispocisiones.
     * 
     */
    public void setActualizadorDispocisiones(int value) {
        this.actualizadorDispocisiones = value;
    }

    /**
     * Obtiene el valor de la propiedad creadorDisposiciones.
     * 
     */
    public int getCreadorDisposiciones() {
        return creadorDisposiciones;
    }

    /**
     * Define el valor de la propiedad creadorDisposiciones.
     * 
     */
    public void setCreadorDisposiciones(int value) {
        this.creadorDisposiciones = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoDisposiciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoDisposiciones() {
        return estadoDisposiciones;
    }

    /**
     * Define el valor de la propiedad estadoDisposiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoDisposiciones(String value) {
        this.estadoDisposiciones = value;
    }

    /**
     * Obtiene el valor de la propiedad idDisposirciones.
     * 
     */
    public int getIdDisposirciones() {
        return idDisposirciones;
    }

    /**
     * Define el valor de la propiedad idDisposirciones.
     * 
     */
    public void setIdDisposirciones(int value) {
        this.idDisposirciones = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDisposiciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDisposiciones() {
        return nombreDisposiciones;
    }

    /**
     * Define el valor de la propiedad nombreDisposiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDisposiciones(String value) {
        this.nombreDisposiciones = value;
    }

}
