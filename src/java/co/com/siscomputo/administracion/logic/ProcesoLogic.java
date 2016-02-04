package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class ProcesoLogic implements IurlWebService{

    private List proceso;
    
    /**
     * Funcion con la cual inicializo el service y el portAdministracion() de los WebServices
     */


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
        
        ArrayList<ProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaProceso().getRetorna();
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
        
        ProcesoEntity dispoRta=null;        
        try {
            //System.out.println("objeto: "+objeto.getNivelProceso());
            dispoRta = portAdministracion().insertarProceso(objeto);
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
        
        String rta="";
        try {            
            System.out.println("OBJ: "+objeto.getAsociadoProceso());
            if (portAdministracion().actualizarProceso(objeto) != null) {
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
        
        ProcesoEntity procesoEntity=new ProcesoEntity();
        try {
            procesoEntity=portAdministracion().procesoPorId2(idProcesos);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procesoEntity;
    }
}