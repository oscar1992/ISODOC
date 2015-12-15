package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.ProcesoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProcesoLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List proceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getProceso() {
        return proceso;
    }

    public void setProceso(List proceso) {
        this.proceso = proceso;
    }
    
    /**
     * Método que trae una lista de Procesos
     * @return 
     */
    public ArrayList<ProcesoEntity> listaProceso(){
        webService();
        ArrayList<ProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaProceso().getRetorna();
        for(Object obj:listaObjeto){
            ProcesoEntity objectproceso=(ProcesoEntity) obj;
            //System.out.println("PROC: "+objectproceso.getNombreProceso());
            listaaux.add(objectproceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Procesosnuevo
     * @param objeto
     * @return 
     */
    public ProcesoEntity insertarProceso(ProcesoEntity objeto){
        webService();
        ProcesoEntity dispoRta=null;        
        try {
            //System.out.println("objeto: "+objeto.getNivelProceso());
            dispoRta = port.insertarProceso(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Procesos
     * @param metodo
     * @return 
     */
    public String actualizarProceso(ProcesoEntity objeto){
        webService();
        String rta="";
        try {            
            System.out.println("OBJ: "+objeto.getAsociadoProceso());
            if (port.actualizarProceso(objeto) != null) {
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
     * Método que trae un proceso por su id
     * @param idProcesos
     * @return 
     */
    public ProcesoEntity procesoPorId(int idProcesos){
        webService();
        ProcesoEntity procesoEntity=new ProcesoEntity();
        try {
            procesoEntity=port.procesoPorId2(idProcesos);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procesoEntity;
    }
}