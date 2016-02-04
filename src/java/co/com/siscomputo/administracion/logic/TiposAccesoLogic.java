package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.TiposAccesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class TiposAccesoLogic implements IurlWebService{

    private List tiposAcceso;
    

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
        
        ArrayList<TiposAccesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaTiposAcceso().getRetorna();
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
        
        TiposAccesoEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarTiposAcceso(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarTiposAcceso(objeto) != null) {
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