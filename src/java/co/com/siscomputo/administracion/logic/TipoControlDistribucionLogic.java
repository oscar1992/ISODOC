package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.TipoControlDistribucionEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoControlDistribucionLogic implements IurlWebService{

    private List tipoControlDistribucion;
    
 

    public List getTipoControlDistribucion() {
        return tipoControlDistribucion;
    }

    public void setTipoControlDistribucion(List tipoControlDistribucion) {
        this.tipoControlDistribucion = tipoControlDistribucion;
    }
    
    /**
     * Método que trae una lista de Tipo de Control de distribución
     * @return 
     */
    public ArrayList<TipoControlDistribucionEntity> listaTipoControlDistribucion(){
        
        ArrayList<TipoControlDistribucionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaTipoControlDistribucion().getRetorna();
        for(Object obj:listaObjeto){
            TipoControlDistribucionEntity objecttipoControlDistribucion=(TipoControlDistribucionEntity) obj;
            listaaux.add(objecttipoControlDistribucion);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Control de distribuciónnuevo
     * @param objeto
     * @return 
     */
    public TipoControlDistribucionEntity insertarTipoControlDistribucion(TipoControlDistribucionEntity objeto){
        
        TipoControlDistribucionEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarTipoControlDistribucion(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Control de distribución
     * @param metodo
     * @return 
     */
    public String actualizarTipoControlDistribucion(TipoControlDistribucionEntity objeto){
        
        String rta="";
        try {            
            if (portAdministracion().actualizarTipoControlDistribucion(objeto) != null) {
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