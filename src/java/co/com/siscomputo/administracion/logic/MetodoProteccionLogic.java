package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.MetodoProteccionEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MetodoProteccionLogic implements IurlWebService{

    private List metodoProteccion;


    public List getMetodoProteccion() {
        return metodoProteccion;
    }

    public void setMetodoProteccion(List metodoProteccion) {
        this.metodoProteccion = metodoProteccion;
    }
    
    /**
     * Método que trae una lista de Métodos de Protección
     * @return 
     */
    public ArrayList<MetodoProteccionEntity> listaMetodoProteccion(){
        
        ArrayList<MetodoProteccionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaMetodoProteccion().getRetorna();
        for(Object obj:listaObjeto){
            MetodoProteccionEntity objectmetodoProteccion=(MetodoProteccionEntity) obj;
            listaaux.add(objectmetodoProteccion);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Métodos de Protecciónnuevo
     * @param objeto
     * @return 
     */
    public MetodoProteccionEntity insertarMetodoProteccion(MetodoProteccionEntity objeto){
        
        MetodoProteccionEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarMetodoProteccion(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Métodos de Protección
     * @param metodo
     * @return 
     */
    public String actualizarMetodoProteccion(MetodoProteccionEntity objeto){
        
        String rta="";
        try {            
            if (portAdministracion().actualizarMetodoProteccion(objeto) != null) {
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