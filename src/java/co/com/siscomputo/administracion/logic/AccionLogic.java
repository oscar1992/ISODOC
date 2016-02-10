package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AccionLogic implements IurlWebService{

    private List accion;

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
        
        ArrayList<AccionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaAccion().getRetorna();
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
        
        AccionEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarAccion(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarAccion(objeto) != null) {
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
        
        AccionEntity accionEntity=new AccionEntity();
        try {
            accionEntity=portAdministracion().accionPorId(idAccion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accionEntity;
    }
    /**
     * Método que trae una lista de acciones por ID
     * @param idUsuario
     * @return 
     */
    public ArrayList<AccionEntity> accionPorUsuario(Integer idUsuario){
        System.out.println("UU");
        ArrayList<AccionEntity> accionEntity=new ArrayList<>();
        ArrayList<Object> listaObjeto=new ArrayList<>();
        try {
            listaObjeto=(ArrayList<Object>) portAdministracion().accionesPorUsuario(idUsuario).getRetorna();
            System.out.println("UU2"+listaObjeto.size());
            for(Object obj:listaObjeto){
                AccionEntity accionEntity1=(AccionEntity) obj;
                accionEntity.add(accionEntity1);                
            }            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EE: "+e);
        }
        return accionEntity;
    }
}