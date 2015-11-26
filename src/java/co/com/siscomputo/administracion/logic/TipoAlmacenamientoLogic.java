package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.TipoAlmacenamientoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoAlmacenamientoLogic {private Administacion_Service webService;
    private Administacion port;
    private List tipoAlmacenamiento;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(List tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }
    
    /**
     * Método que trae una lista de Tipo de Almacenamiento
     * @return 
     */
    public ArrayList<TipoAlmacenamientoEntity> listaTipoAlmacenamiento(){
        webService();
        ArrayList<TipoAlmacenamientoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaTipoAlmacenamiento().getRetorna();
        for(Object obj:listaObjeto){
            TipoAlmacenamientoEntity objecttipoAlmacenamiento=(TipoAlmacenamientoEntity) obj;
            listaaux.add(objecttipoAlmacenamiento);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Almacenamientonuevo
     * @param objeto
     * @return 
     */
    public TipoAlmacenamientoEntity insertarTipoAlmacenamiento(TipoAlmacenamientoEntity objeto){
        webService();
        TipoAlmacenamientoEntity dispoRta=null;        
        try {
            dispoRta = port.insertarTipoAlmacenamiento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Almacenamiento
     * @param metodo
     * @return 
     */
    public String actualizarTipoAlmacenamiento(TipoAlmacenamientoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarTipoAlmacenamiento(objeto) != null) {
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