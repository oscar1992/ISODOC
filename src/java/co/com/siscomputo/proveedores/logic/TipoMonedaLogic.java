package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.TipoMonedaEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoMonedaLogic implements IurlWebService{
    private List tipoMoneda;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(List tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
    
    /**
     * Método que trae una lista de Tipo de Moneda
     * @return 
     */
    public ArrayList<TipoMonedaEntity> listaTipoMoneda(){
        ArrayList<TipoMonedaEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaTipoMoneda().getRetorna();
        for(Object obj:listaObjeto){
            TipoMonedaEntity objecttipoMoneda=(TipoMonedaEntity) obj;
            listaaux.add(objecttipoMoneda);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Monedanuevo
     * @param objeto
     * @return 
     */
    public TipoMonedaEntity insertarTipoMoneda(TipoMonedaEntity objeto){
        TipoMonedaEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarTipoMoneda(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Moneda
     * @param metodo
     * @return 
     */
    public String actualizarTipoMoneda(TipoMonedaEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarMoneda(objeto)!= null) {
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