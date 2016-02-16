package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.CertificadoCalidadEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CertificadoCalidadLogic implements IurlWebService{
    private List certificadoCalidad;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getCertificadoCalidad() {
        return certificadoCalidad;
    }

    public void setCertificadoCalidad(List certificadoCalidad) {
        this.certificadoCalidad = certificadoCalidad;
    }
    
    /**
     * Método que trae una lista de Certificado de Calidad
     * @return 
     */
    public ArrayList<CertificadoCalidadEntity> listaCertificadoCalidad(){
        ArrayList<CertificadoCalidadEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listarCertificado().getRetorna();
        for(Object obj:listaObjeto){
            CertificadoCalidadEntity objectcertificadoCalidad=(CertificadoCalidadEntity) obj;
            listaaux.add(objectcertificadoCalidad);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Certificado de Calidadnuevo
     * @param objeto
     * @return 
     */
    public CertificadoCalidadEntity insertarCertificadoCalidad(CertificadoCalidadEntity objeto){
        CertificadoCalidadEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarCertificado(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Certificado de Calidad
     * @param metodo
     * @return 
     */
    public String actualizarCertificadoCalidad(CertificadoCalidadEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarCertificado(objeto) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta="Error";
            e.printStackTrace();            
        }
        return rta;
    }
}