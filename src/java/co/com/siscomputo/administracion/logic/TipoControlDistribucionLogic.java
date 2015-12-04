package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.TipoControlDistribucionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoControlDistribucionLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List tipoControlDistribucion;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

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
        webService();
        ArrayList<TipoControlDistribucionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaTipoControlDistribucion().getRetorna();
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
        webService();
        TipoControlDistribucionEntity dispoRta=null;        
        try {
            dispoRta = port.insertarTipoControlDistribucion(objeto);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarTipoControlDistribucion(objeto) != null) {
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