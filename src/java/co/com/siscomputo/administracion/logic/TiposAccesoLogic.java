package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.TiposAccesoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TiposAccesoLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List tiposAcceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getTiposAcceso() {
        return tiposAcceso;
    }

    public void setTiposAcceso(List tiposAcceso) {
        this.tiposAcceso = tiposAcceso;
    }
    
    /**
     * Método que trae una lista de Tipo de Acceso
     * @return 
     */
    public ArrayList<TiposAccesoEntity> listaTiposAcceso(){
        webService();
        ArrayList<TiposAccesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaTiposAcceso().getRetorna();
        for(Object obj:listaObjeto){
            TiposAccesoEntity objecttiposAcceso=(TiposAccesoEntity) obj;
            listaaux.add(objecttiposAcceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Accesonuevo
     * @param objeto
     * @return 
     */
    public TiposAccesoEntity insertarTiposAcceso(TiposAccesoEntity objeto){
        webService();
        TiposAccesoEntity dispoRta=null;        
        try {
            dispoRta = port.insertarTiposAcceso(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Acceso
     * @param metodo
     * @return 
     */
    public String actualizarTiposAcceso(TiposAccesoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarTiposAcceso(objeto) != null) {
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