package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.AccionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AccionLogic {private Administacion_Service webService;
    private Administacion port;
    private List accion;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getAccion() {
        return accion;
    }

    public void setAccion(List accion) {
        this.accion = accion;
    }
    
    /**
     * Método que trae una lista de Acción
     * @return 
     */
    public ArrayList<AccionEntity> listaAccion(){
        webService();
        ArrayList<AccionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaAccion().getRetorna();
        for(Object obj:listaObjeto){
            AccionEntity objectaccion=(AccionEntity) obj;
            listaaux.add(objectaccion);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Acciónnuevo
     * @param objeto
     * @return 
     */
    public AccionEntity insertarAccion(AccionEntity objeto){
        webService();
        AccionEntity dispoRta=null;        
        try {
            dispoRta = port.insertarAccion(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Acción
     * @return 
     */
    public String actualizarAccion(AccionEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarAccion(objeto) != null) {
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
    /**
     * Método que trae una acción por ID
     * @param idAccion
     * @return 
     */
    public AccionEntity accionPorId(Integer idAccion){
        webService();
        AccionEntity accionEntity=new AccionEntity();
        try {
            accionEntity=port.accionPorId(idAccion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accionEntity;
    }
    /**
     * Método que trae una lista de acciones por ID
     * @param idAccion
     * @return 
     */
    public ArrayList<AccionEntity> accionPorUsuario(Integer idUsuario){
        webService();
        ArrayList<AccionEntity> accionEntity=new ArrayList<>();
        ArrayList<Object> listaObjeto=new ArrayList<>();
        try {
            listaObjeto=(ArrayList<Object>) port.accionPorUsuario(idUsuario).getRetorna();
            for(Object obj:listaObjeto){
                AccionEntity accionEntity1=(AccionEntity) obj;
                accionEntity.add(accionEntity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accionEntity;
    }
}