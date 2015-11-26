package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.MetodoProteccionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MetodoProteccionLogic {private Administacion_Service webService;
    private Administacion port;
    private List metodoProteccion;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

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
        webService();
        ArrayList<MetodoProteccionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaMetodoProteccion().getRetorna();
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
        webService();
        MetodoProteccionEntity dispoRta=null;        
        try {
            dispoRta = port.insertarMetodoProteccion(objeto);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarMetodoProteccion(objeto) != null) {
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