package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.TipoAlmacenamientoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class TipoAlmacenamientoLogic implements IurlWebService{

    private List tipoAlmacenamiento;
    
    /**
     * Funcion con la cual inicializo el service y el portAdministracion() de los WebServices
     */


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
        
        ArrayList<TipoAlmacenamientoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaTipoAlmacenamiento().getRetorna();
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
        
        TipoAlmacenamientoEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarTipoAlmacenamiento(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarTipoAlmacenamiento(objeto) != null) {
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